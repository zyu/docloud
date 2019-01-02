package com.docloud.consumer.service;

/**
 * 客户端调用者
 */
public class Invoker {

	private Command command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		this.command.execute();
	}

}
