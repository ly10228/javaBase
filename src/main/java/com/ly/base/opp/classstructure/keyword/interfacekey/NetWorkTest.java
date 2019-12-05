package com.ly.base.opp.classstructure.keyword.interfacekey;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: NetWorkTest
 * @create 2019-11-18 23:01
 * @last modify by [LuoYong 2019-11-18 23:01]
 **/
public class NetWorkTest {

    @Test
    public void test() {
        Server server = new Server();
//		server.browse();
        ProxyServer proxyServer = new ProxyServer(server);

        proxyServer.browse();
    }
}


interface NetWork {

    void browse();

}

//被代理类
class Server implements NetWork {

    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }

}

//代理类
class ProxyServer implements NetWork {

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }


    public void check() {
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        check();

        work.browse();

    }

}