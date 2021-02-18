package com.china.hcg.set;

import java.util.*;

/**
 * @autor hecaigui
 * @date 2020-11-16
 * @description
 */
public class List {
//	list转map：
//	https://blog.csdn.net/linsongbin1/article/details/79801952
	/**
	 * list分割成若干个list
	 * <p>
	 *         调用案例：
	 *         List<List<EgovCommonContacts>> averageList= averageList(list,list.size()/200<1?1:list.size()/200);
	 *         for (List<EgovCommonContacts> insertList: averageList) {
	 *             result+=this.egovCommonContactDao.insertEgovCommonContactsByBatch(insertList);
	 *         }
	 * </p>
	 * @param list
	 * @return
	 */
	public static <T> java.util.List<java.util.List<T>> averageList(java.util.List<T> list, int n){
		java.util.List<java.util.List<T>> result=new ArrayList<java.util.List<T>>();
		int remaider=list.size()%n;  //(先计算出余数)
		int number=list.size()/n;  //然后是商
		int offset=0;//偏移量
		for(int i=0;i<n;i++){
			java.util.List<T> value=null;
			if(remaider>0){
				value=list.subList(i*number+offset, (i+1)*number+offset+1);
				remaider--;
				offset++;
			}else{
				value=list.subList(i*number+offset, (i+1)*number+offset);
			}
			result.add(value);
		}
		return result;
	}

//	HashSet hashSet
//	TreeSet hashSet
	public static void main(String[] args) {

	}
}
