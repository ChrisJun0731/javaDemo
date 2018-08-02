package aliyun;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import utils11.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/25.
 */
public class YiYuanLotteryHis {
	public static void main(String[] args) {
		String host = "https://ali-lottery.showapi.com";
		String path = "/multi";
		String method = "GET";
		String appcode = "6e4a94d3fe7c46ddb7c3b93d4c4a97a7";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		//重庆时时彩
		querys.put("code", "cqssc");
		querys.put("count", "50");
//		querys.put("endTime", String.valueOf(new Date().getTime()));


		try {
			/**
			 * 重要提示如下:
			 * HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			System.out.println(response.toString());
			//获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
