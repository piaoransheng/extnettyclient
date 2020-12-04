package com.lhc.kryocoder;

import com.lhc.dto.OrgStationDO;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.UUID;

public class TesKryo {
    public static void main(String[] args) {
        testSerialize();
    }

    private static void testSerialize() {
        OrgStationDO orgStationDO = new OrgStationDO();
        orgStationDO.setId(UUID.randomUUID().toString());
        orgStationDO.setCode("站点编码1");
        orgStationDO.setName("站点名称1");
        System.out.println("原生站点：" + orgStationDO);


        ByteBuf byteBuf = Unpooled.buffer();
        KryoSerializer.serialize(orgStationDO, byteBuf);
        OrgStationDO deserialize = (OrgStationDO) KryoSerializer.deserialize(byteBuf);
        System.out.println("序列化站点：" + deserialize);
    }
}