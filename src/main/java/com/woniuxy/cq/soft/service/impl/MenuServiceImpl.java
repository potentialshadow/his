package com.woniuxy.cq.soft.service.impl;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.Menu;
import com.woniuxy.cq.soft.entity.MenuExample;
import com.woniuxy.cq.soft.mapper.MenuMapper;
import com.woniuxy.cq.soft.service.MenuService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selectPermission(Employees employee) throws Exception {
		List<Menu> list = menuMapper.selectPermission(employee);
		List<Menu> rootList = new ArrayList<>();
		for (Menu menu : list) {
			if(menu.getPid()==0) {
				rootList.add(menu);
				menu.setChildren(new ArrayList<Menu>());
			}
		}
		for (Menu menu : list) {
			if(menu.getPid()!=0) {
				for (Menu root : rootList) {
					if(root.getId()==menu.getPid()) {
						root.getChildren().add(menu);
						break;
					}
				}
			}
		}
		list=null;
		return rootList;
	}
	@Override
	public List<Menu> selectMenuByUid(Integer id) throws Exception {
		List<Menu> list = menuMapper.selectMenuByUid(id);
		List<Menu> rootList = new ArrayList<>();
		for (Menu menu : list) {
			if(menu.getPid()==0) {
				rootList.add(menu);
				menu.setChildren(new ArrayList<Menu>());
			}
		}
		for (Menu menu : list) {
			if(menu.getPid()!=0) {
				for (Menu root : rootList) {
					if(root.getId()==menu.getPid()) {
						root.getChildren().add(menu);
						break;
					}
				}
			}
		}
		list=null;
		return rootList;
	}
	@Override
	public List<Menu> selectButton(Integer pid) throws Exception {
		MenuExample example = new MenuExample();
		example.createCriteria().andPidEqualTo(pid);
		example.createCriteria().andLevelEqualTo(3);
		return menuMapper.selectByExample(example);
	}

}
