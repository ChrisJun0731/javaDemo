package aliyun;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import utils11.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/24.
 */
public class HZLotteryHistoryAPITest {
	public static void main(String[] args) {
		String host = "http://jisucpkj.market.alicloudapi.com";
		String path = "/caipiao/history";
		String method = "GET";
		String appcode = "6e4a94d3fe7c46ddb7c3b93d4c4a97a7";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("caipiaoid", "73");
		querys.put("num", "10");


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
//			System.out.println(response.toString());
			//获取response的body
//			System.out.println(EntityUtils.toString(response.getEntity()));

			String jsonStr = EntityUtils.toString(response.getEntity());
			JSONObject jsonObj = JSONObject.fromObject(jsonStr);
			JSONObject result = (JSONObject)jsonObj.get("result");
			JSONArray list = (JSONArray)result.get("list");
			for(Object lottery: list){
				String issueNo = (String)((JSONObject)lottery).get("issueno");
				String number = (String) (((JSONObject) lottery).get("number"));
				System.out.println("issueNo: " + issueNo + "; number: " + number);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
