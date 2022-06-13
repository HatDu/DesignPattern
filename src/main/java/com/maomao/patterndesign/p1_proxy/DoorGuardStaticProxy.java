package com.maomao.patterndesign.p1_proxy;

class DoorGuard implements Door{
    Door door;

    public DoorGuard(Door door){
        this.door = door;
    }

    @Override
    public String open(String userName) {
        preInvoke(userName);
        
        String rst = null;
        if(userName!=null && userName.contains("z")){
            rst = this.door.open(userName);
        }
        else{
            rst = userName + "无权经过此门";
        }
        System.out.println(rst);
        postInvoke(userName);
        return null;
    }
    
    private void preInvoke(String userName){
        System.out.println(userName + "尝试经过此门");
    }

    private void postInvoke(String userName){
        System.out.println(userName + "经过了此门");
    }
}

public class DoorGuardStaticProxy{

    public static void main(String[] args) {
        DoorGuard guard = new DoorGuard(new WoddenDoor());

        guard.open("zhang san");
    }
}
