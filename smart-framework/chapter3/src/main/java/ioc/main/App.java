package ioc.main;

import ioc.bean.Boss;
import ioc.bean.SmartBoss;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by wh1te on 2017/11/30.
 */
public class App {
    public static void main(String[] args) {
        bossGoSomeWhere();
        smartBossGoSomewhere();
    }

    static void bossGoSomeWhere(){
        Boss boss = new Boss();
        boss.goSomeWhere();
    }

    static void smartBossGoSomewhere() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                App.class);
        try {
            SmartBoss boss = context.getBean(SmartBoss.class);
            boss.goSomewhere();
        } finally {
            context.close();
        }
    }


}
