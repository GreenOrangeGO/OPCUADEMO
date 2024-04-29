package com.neu;

import com.kangaroohy.milo.service.MiloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
    @Component
    @Slf4j
    public class CustomRunner implements ApplicationRunner {

        @Autowired
        private MiloService miloService;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            sub();
        }

        private void sub() throws Exception {
            List<String> ids = new ArrayList<>();
            ids.add("通道 1.设备 1.标记1");
            ids.add("通道 1.设备 1.标记2");
            miloService.subscriptionFromOpcUa(ids, (id, value) -> log.info("subscription 点位：{} 订阅到消息：{}", id, value));
        }
    }

