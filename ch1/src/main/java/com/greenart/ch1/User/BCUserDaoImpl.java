package com.greenart.ch1.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // �ϴ� DB�� ������Ʈ�� ����
public class BCUserDaoImpl implements BCUserDao  {
	@Autowired
	SqlSession session; // session ����, sql����� �����ϴµ� �ʿ��� �޼��� ����
	
	String namespace = "com.greenart.ch1.";
	
//	���̵� ����
	@Override
	public int selectIdCount(String id) throws Exception {
		return session.selectOne(namespace + "selectIdCount",id);
	}
	
//	���̵� ã��
	@Override
	public BCUserDto idToEmail(String name, String email) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		return session.selectOne(namespace + "idToEmail", map);
	}
	
//	��й�ȣ ã��
	@Override
	public BCUserDto pwdToEmail(String id, String name, String email) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		return session.selectOne(namespace + "pwdToEmail", map);
	}
	
//	�̸��� Ȯ��
	@Override
	public int confirmEmail(String email) throws Exception {
		return session.selectOne(namespace + "confirmEmail", email);
	}
	
//	�� ���� ã��
	@Override
	public BCUserDto selectUser(String id) throws Exception {
		return session.selectOne(namespace + "selectUser", id);
	}
	
// �� ���� ����
	@Override
	public int deleteUser (String id, String pwd) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		return session.delete(namespace + "deleteUser", map);
	}
	
//	�� ���� ���
	@Override
	public int insertUser(BCUserDto bcuserDto) throws Exception {
		return session.insert(namespace + "insertUser", bcuserDto);
	}
	
//	�� ���� ������Ʈ
	@Override
	public int updateUserPwd(String id, String pwd) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		return session.update(namespace + "updateUserPwd", map);
	}
	@Override
	public int updateUserEmail(String id, String email) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("email", email);
		return session.update(namespace + "updateUserEmail", map);
	}
	@Override
	public int updateUserTel(String id, String tel) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("tel", tel);
		return session.update(namespace + "updateUserTel", map);
	}
	
	
//	�� ���� ��ü ����
	@Override
	public int deleteAll() {
		return session.delete(namespace + "u_deleteAll");
	}
//	�� ���� ��ü �˻�
	@Override
	public List<BCUserDto> selectAll() throws Exception {
		return session.selectList(namespace + "u_selectAll");
	}
	
}