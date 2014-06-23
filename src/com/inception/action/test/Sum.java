package com.inception.action.test;

import com.opensymphony.xwork2.ActionSupport;

public class Sum extends ActionSupport {

	private int operand1;
	private int operand2;

	public String execute() throws Exception {
		if (getSum() >= 0) // ������������ǷǸ�����������positive.jsp ҳ��
		{
			return "positive";
		} else // ������������Ǹ�����������negative.jsp ҳ��
		{
			return "negative";
		}
	}

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		System.out.println(operand1);
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		System.out.println(operand2);
		this.operand2 = operand2;
	}

	public int getSum() {
		return operand1 + operand2; // �������������Ĵ�������
	}
}
