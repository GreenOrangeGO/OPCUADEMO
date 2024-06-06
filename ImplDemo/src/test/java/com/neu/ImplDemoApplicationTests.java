package com.neu;

import com.kangaroohy.milo.model.ReadWriteEntity;
import com.kangaroohy.milo.pool.MiloConnectPool;
import com.kangaroohy.milo.service.MiloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ImplDemoApplicationTests {

    @Autowired
    MiloService miloService;
//    @Autowired
//    MiloConnectPool miloConnectPool;

    @Test
    public void read() throws Exception {
        System.out.println(miloService.readFromOpcUa("通道 7.设备 1.PLC_1.Q1_1").getValue());
    }
    @Test
    public void write() throws Exception {
        miloService.writeToOpcShort(
                ReadWriteEntity.builder()
                        .identifier("通道 1.设备 1.标记1")
                        .value(111)
                        .build());
    }
    @Test
    public void browseNode() throws Exception {
        System.out.println(miloService.readFromOpcUa(miloService.browseNode("通道 7")));
    }
    @Test
    public void browseRoot() throws Exception {
        System.out.println(miloService.browseRoot());
    }

}
