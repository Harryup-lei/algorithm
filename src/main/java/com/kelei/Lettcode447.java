package com.kelei;

public class Lettcode447 {
	public int numberOfBoomerangs(int[][] points) {
		//时间复杂度On^3,空间复杂度O1
		int res = 0;
		int n = points.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(j == i){
					continue;
				}
				for(int k = 0; k < n; k++){
					if(k == i || k == j){
						continue;
					}
					long a = (points[i][0] * 1l - points[j][0] * 1l) * (points[i][0] * 1l - points[j][0] * 1l)
							+ (points[i][1] * 1l - points[j][1] * 1l) * (points[i][1] * 1l - points[j][1] * 1l);
					long b = (points[i][0] * 1l - points[k][0] * 1l) * (points[i][0] * 1l - points[k][0] * 1l)
							+ (points[i][1] * 1l - points[k][1] * 1l) * (points[i][1] * 1l - points[k][1] * 1l);
					if(a == b){
						res += 1;
					}
				}
			}
		}
		return res;
	}
}
