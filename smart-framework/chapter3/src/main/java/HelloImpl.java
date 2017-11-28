/**
 * Created by wh1te on 2017/11/28.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello!"+name);
    }
}
