package comm.globaclass;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

 

public class LoadConfig extends Properties {
	private static final long serialVersionUID = -8785963230469619571L;
	private static Map<String, Properties> map = new HashMap<String, Properties>();
	private static Properties props = null;

	/*
	 * ����key��ȡĬ���ļ�postgres.properties��key?
	 */
	public static String getValueByKey(String key) {
		props = map.get(GlobalNames.CONFIG_FILE);
		if (props == null) {
			new LoadConfig().loadFile(GlobalNames.CONFIG_FILE);
			props = map.get(GlobalNames.CONFIG_FILE);
		}
		return props.containsKey(key) ? props.get(key).toString() : null;
	}

	/*
	 * ����key��ȡĬ���ļ�fileName��key?
	 */
	public static String getValueByKey(String key, String fileName) {
		props = map.get(fileName);
		if (props == null) {
			new LoadConfig().loadFile(fileName);
			props = map.get(fileName);
		}
		return props.containsKey(key) ? props.get(key).toString() : null;
	}

	/*
	 * װ���ļ���properties������ȥ��������ڼ�ֵ������
	 */
	private void loadFile(String filename) {
		props = new Properties();

		try {
			InputStream stream = LoadConfig.class.getClassLoader().getResourceAsStream(filename);
			props.load(stream);
			map.put(filename, props);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ����س���!" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���쳣��");
		}
	}

	public static void main(String[] args) {
		System.out.println(LoadConfig.getValueByKey("0","resource/properties/config.properties"));
	}

}