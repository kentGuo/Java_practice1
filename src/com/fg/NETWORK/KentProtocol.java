package com.fg.NETWORK;

public interface KentProtocol {
	//定义协议字符串的长度
	int PROROCOL_LEN=2;
	//下面是一些协议字符串，服务器端和客户端交换的信息都应该在前后添加这种特殊字符串
	String MSG_ROUND="§γ";
	String USER_ROUND="Ⅱ∑";
	String LOGIN_SUCESS="1";
	String NAME_REP="-1";
	String PRIVATE_ROUND="★【";
	String SPLIT_SIGN="※";
}
