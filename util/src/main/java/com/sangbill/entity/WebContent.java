package com.sangbill.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 问卷实体类
 * 
 * @author ea
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebContent  {
	private String url;
	private List<Dir> dirList;//目录列表
	@Data
	@EqualsAndHashCode
	@NoArgsConstructor
	public static class Dir {
		String name;
		private List<String> imgList;//图片列表
	}
}
