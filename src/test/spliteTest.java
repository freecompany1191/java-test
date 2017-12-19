package test;

public class spliteTest {

    public static void main(String[] args) {

        String addr = "난곡동 (구 신림3동+신림13동) 서울시 관악구 난곡로31길 32-4 현대빌라 101호";

        String[] sp = addr.split(" ");

        //System.out.println(sp.length);

        boolean chk = false;

        while(addr != null){

            //            addr = nextAddr(addr);
            //            System.out.println(addr);

            addr = beforeAddr(addr);
            System.out.println(addr);

        }

        System.out.println("final = "+addr);
    }

    /**
     * 뒤에서부터 공백을 기준으로 한블럭씩 잘라냄
     * @Method Name : nextAddr
     * @param address
     * @return
     */
    private static String nextAddr(String address) {
        if (address.length() < 10) {
            return null;
        }

        String[] temp = address.split(" ");

        for (int i = 0; i < temp.length ; i++) {
            System.out.println("### temp["+i+"] = "+temp[i]);
        }

        if (temp == null || temp.length <= 3) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.length - 1; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    /**
     * 앞에서부터 공백을 기준으로 한블럭씩 잘라냄
     * @Method Name : beforeAddr
     * @param address
     * @return
     */
    private static String beforeAddr(String address) {
        if (address.length() < 10) {
            return null;
        }

        String[] temp = address.split(" ");

        for (int i = 0; i < temp.length ; i++) {
            System.out.println("### temp["+i+"] = "+temp[i]);
        }

        if (temp == null || temp.length <= 2) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            stringBuilder.append(temp[i]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
