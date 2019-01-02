package com.docloud.consumer.service;

/**
 * ●Receiver：接收者，它知道如何处理具体的业务逻辑
 * ●Command：抽象命令，它定义了一个命令对象应具备的一系列命令操作，比如execute()、 undo()、 redo()等。当命令操作被调用的时候就会触发接收者去做具体命令对应的业务逻辑
 * ●ConcreteCommand：具体的命令实现，在这里它绑定了命令操作与接收者之间的关系，execute()命令的实现委托给了Receiver的action()函数
 * ●Invoker：调用者，它持有一个命令对象，并且可以在需要的时候通过命令对象完成具体的业务逻辑
 */
public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action(); // 客 户 端 通 过 调 用 者 来 执 行 命 令
	}
}
