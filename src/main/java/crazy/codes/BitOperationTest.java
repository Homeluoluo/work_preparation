package crazy.codes;

/**
 * @Classname BitOperationTest
 * @Description TODO
 * @Date 2019/4/18 11:04
 * @Created by luojia
 */
public class BitOperationTest {
    public static void main(String[] args) {
        // 初始化短信对象
        Sms sms = new Sms();
        System.out.println("初始化短信：" + sms);

        // 给短信设定主题
        sms.updateSmsState(HAS_SUBJECT, true);
        System.out.println("短信添加主题后：" + sms);

        // 给短信设定附件
        sms.updateSmsState(HAS_ATTACHMENT, true);
        System.out.println("短信添加附件后：" + sms);

        // 给短信设定正文
        sms.updateSmsState(HAS_CONTENT, true);
        System.out.println("短信添加正文后：" + sms);

        // 短信不能含有附件
        sms.updateSmsState(HAS_ATTACHMENT, false);
        System.out.println("短信去除附件后：" + sms);
    }
//按位与的用途：清零，取特定位的值
    public static void useBitAnd(){
//        1、为number最后1位,清零。
        int ZERO_FLAG = 0xfe;// 0x 1111 1110 ZERO_FLAG = ~LAST_BIT_FLAG ;
        int number = 0x6f; //0x 0110 1111;
        int result = number & ZERO_FLAG; //0x 0110 0000;
        System.out.println("number is:"+number
                +",result is:"+result);
//输出：number is:111,result is:110

//分2、别取出number的高四位，与低四位
        int LOWER_FOUR_BIT_FLAG = 0x0f;//0x 0000 1111  取低四位
        int HIGH_FOUR_BIT_FLAG = 0xf0;//0x 1111 0000  取高四位
        int lowResult = number & LOWER_FOUR_BIT_FLAG; //0x 0000 1111;
        int highResult = number & HIGH_FOUR_BIT_FLAG; //0x 0110 0000;
        System.out.println("number is:"+number
                +",lower4bit is:"+lowResult
                +",high4bit is:"+highResult);
//输出：number is:111,lower4bit is:15,high4bit is:96
    }

//    按位或的用途：将指定位设置为1
    public static void useBitOr(){
//        将最后一位设为1
        int LAST_BIT_FLAG = 0x01;
        int number = 0x60; //0x 0110 0000;
        int result = number | LAST_BIT_FLAG; //0x 0110 0001;
        System.out.println("number is:"+number
                +",result is:"+result);
//  输出：number is:96,result is:97
    }
//    按位异或的用途
    public static void useBitXor(){

    }

    public static void test(){
        int a=60;
        int b=13;
        int c= -60;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a<<2);
        System.out.println(a>>2);
        System.out.println(c>>2);
        System.out.println(a>>>2);
//        >>>只能用于无符号数右移补零
        System.out.println(c>>>2);
        System.out.println(a^b);
//        按位取反
        System.out.println(~a);
    }

    private static final int HAS_SUBJECT = (1 << 0); // 1{0000 0001}
    private static final int HAS_ATTACHMENT = (1 << 1); // 2{0000 0010}
    private static final int HAS_CONTENT = (1 << 2); // 4{0000 0100}

    static class Sms {
        // 短信，初始化flag = 0，不含有主题、附件、正文
        private int flags = 0;

        private void updateSmsState(int state, boolean has) {
            int oldFlags = flags;
            if (has) {
                flags |= state;
            } else {
                flags &= ~state;
            }
            // 按位 异或，得到变化的flags
            int flagsChanges = oldFlags ^ flags;
            if ((flagsChanges & HAS_SUBJECT) != 0) {
                System.out.println("\t【主题】标记状态发生了改变！");
            } else if ((flagsChanges & HAS_ATTACHMENT) != 0) {
                System.out.println("\t【附件】标记状态发生了改变！");
            } else if ((flagsChanges & HAS_CONTENT) != 0) {
                System.out.println("\t【正文】标记状态发生了改变！");
            } else {
                System.out.println("\tflags标记状态没有发生改变！");
            }
        }

        private boolean hasSmsSubject(int smsFlag) {
            return (smsFlag & HAS_SUBJECT) > 0;
        }

        private boolean hasSmsAttachment(int smsFlag) {
            return (smsFlag & HAS_ATTACHMENT) > 0;
        }

        private boolean hasSmsContent(int smsFlag) {
            return (smsFlag & HAS_CONTENT) > 0;
        }

        public String toString() {
            String hasSubject = hasSmsSubject(flags) ? "[主题]" : "";
            String hasAttachment = hasSmsAttachment(flags) ? "[附件]" : "";
            String hasContent = hasSmsContent(flags) ? "[正文]" : "";
            return "短信：" + hasSubject
                    + "," + hasAttachment
                    + "," + hasContent;
        }
    }
}
