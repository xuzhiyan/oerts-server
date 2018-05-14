/**
 * @FileName:		RasUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月15日 上午1:23:08
 *
 */
package com.njfu.bysj.oerts.utils;

import com.njfu.bysj.oerts.bean.CompleteRegistExam;

/**
 * @ClassName: RasUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月15日 上午1:23:08
 *
 */
public class RasUtil {

	public int[] createRoomAndSeat(CompleteRegistExam result) {

		// 返回的考场号和座位号
		int[] ras = new int[2];

		if (result == null) {
			// 还没有人报名成功
			ras[0] = 1;
			ras[1] = 1;
			return ras;
		} else {
			// 已经有人报名成功了
			// 查询对应Id的考试报名成功里面的座位号
			if (result.getSetNum() == result.getHallNum()) {
				// 一个考场人数已满，需要另外开一个考场
				ras[0] = result.getRoomNum() + 1;
				ras[1] = 1;
				return ras;
			} else {
				// 人数没满
				ras[0] = result.getRoomNum();
				ras[1] = result.getSetNum() + 1;
				return ras;
			}
		}
	}
}
