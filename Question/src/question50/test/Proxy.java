package question50.test;

public class Proxy implements IUserService {

    private IUserService service;

    public Proxy(IUserService service){
        this.service=service;
    }

    @Override
    public void doSomething() {
        proxyMethod();
        service.doSomething();
    }

    private void proxyMethod(){

    }
}
