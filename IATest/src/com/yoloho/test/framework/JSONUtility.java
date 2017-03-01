package com.yoloho.test.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtility {

	public static JSONObject String2JSON(String str) {
		return JSONObject.fromObject(str);

	}

	public static JSONObject Map2JSON(Map<?, ?> map) {

		return JSONObject.fromObject(map);
	}

	public static Map<String, Object> JSON2Map(JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object key : json.keySet()) {
			Object value = json.get(key);
			if (value instanceof JSONArray) {
				List list = new ArrayList();
				Iterator it = ((JSONArray) value).iterator();
				while (it.hasNext()) {
					JSONObject jason = (JSONObject) it.next();
					list.add(JSON2Map(jason));
				}
				map.put(key.toString(), list);
			} else if (value instanceof JSONObject) {
				map.put(key.toString(), JSON2Map((JSONObject) value));
			} else {
				map.put(key.toString(), value);
			}
		}
		return map;
	}

	public static boolean Compare2JSONSize(JSONObject json1, JSONObject json2) {
		if (json1 == null || json2 == null) {
			return false;
		}
		if (json1.size() != json2.size()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean Compare2JSONKeys(JSONObject json1, JSONObject json2) throws KeyErrorException {

		boolean result = false;
		String errorMsg = "[Error:Compare2JSONKeys:JSONUtility:]";
		JSONArray keys1, keys2;
		keys1 = json1.names();
		keys2 = json2.names();
		Iterator it1 = keys1.iterator();
		Iterator it2 = keys2.iterator();

		if (keys1.size() == 0) {
			if (keys2.size() == 0) {
				result = true;
				return result;
			} else {
				result = false;
				errorMsg += "JSON1 does NOT equal JSON2 \n\r";
				errorMsg += "JSON1 is NULL" + json1.toString() + "\n\r";
				errorMsg += "JSON2 is NOT NULL" + json2.toString() + "\n\r";
				throw new KeyErrorException(errorMsg);
			}
		}
		while (it1.hasNext()) {
			String k1 = it1.next().toString();
			it2 = keys2.iterator();
			while (it2.hasNext()) {
				String k2 = it2.next().toString();
				if (k1.equals(k2)) {
					result = true;
					if (json1.get(k1).getClass().getSimpleName().toString().equals("JSONObject")
							&& (!json1.get(k1).toString().equals("null"))) {

						if (Compare2JSONKeys((JSONObject) json1.get(k1), (JSONObject) json2.get(k2))) {

						} else {
							result = false;
							errorMsg += "Key:" + k1;
							errorMsg += " Keys in SubJSONObject json1:" + ((JSONObject) json1.get(k1)).toString()
									+ " Does NOT Equal" + " Keys in SubJSONObject json2:"
									+ ((JSONObject) json2.get(k2)).toString();
							errorMsg += "\n\r";
							throw new KeyErrorException(errorMsg);
							// return result;
						}

					} else if (json1.get(k1).getClass().getSimpleName().toString().equals("JSONArray")) {

						Iterator it3 = ((JSONArray) json1.get(k1)).iterator();
						Iterator it4 = ((JSONArray) json2.get(k2)).iterator();
						while (it3.hasNext()) {
							Object obj = it3.next();
							if (!obj.getClass().getSimpleName().equals("JSONObject")) {
								continue;
							}
							JSONObject subjson1 = (JSONObject) (obj);
							if (!it4.hasNext()) {
								it4 = ((JSONArray) json2.get(k2)).iterator();
							}
							while (it4.hasNext()) {
								JSONObject subjson2 = (JSONObject) (it4.next());
								if (Compare2JSONKeys(subjson1, subjson2)) {
									break;
								} else {
									if (!it4.hasNext()) {
										result = false;

										errorMsg += "Key in SubJSON1:" + k1 + "Does NOT Equal Key in SubJSON2:" + k2
												+ "\n\r";
										errorMsg += "SubJSON1:" + subjson1 + "\n\r";
										errorMsg += "SubJSON2:" + subjson2 + "\n\r";
										throw new KeyErrorException(errorMsg);

									}
								}
							}

						}
					} else {
					}

					if (!it2.hasNext()) {
						it2 = keys2.iterator();
					}
					break;
				} else {
					if (!it2.hasNext()) {

						errorMsg += "Key in JSON1:" + k1 + "Does NOT Equal Key in JSON2:" + k2 + "\n\r";
						errorMsg += "JSON1:" + json1;
						errorMsg += "JSON2:" + json2;
						throw new KeyErrorException(errorMsg);
					}
					result = false;
				}
			}
		}
		return result;
	}

	public static boolean Compare2JSONValues(JSONObject json1, JSONObject json2, int flag) throws ValueErrorException {
		String errorMsg = "[Error:Compare2JSONValues:JSONUtility:]";
		boolean result = false;
		JSONArray keys1, keys2;
		keys1 = json1.names();
		keys2 = json2.names();
		Iterator it1 = keys1.iterator();
		Iterator it2 = keys2.iterator();
		int intflag;
		intflag = flag;
		if (keys1.size() == 0) {
			if (keys2.size() == 0) {
				result = true;
				return result;
			} else {
				result = false;
				errorMsg += "JSON1 does NOT equal JSON2 \n\r";
				errorMsg += "JSON1 is NULL" + json1.toString() + "\n\r";
				errorMsg += "JSON2 is NOT NULL" + json2.toString() + "\n\r";
				throw new ValueErrorException(errorMsg);
			}
		}
		while (it1.hasNext()) {
			String k1 = it1.next().toString();
			while (it2.hasNext()) {
				String k2 = it2.next().toString();
				if (json1.get(k1).getClass().getSimpleName().toString().equals("JSONObject")
						&& (!json1.get(k1).toString().equals("null"))) {
					intflag++;
					if (k1.equals(k2) && (!k1.equals("timestamp"))) {
						if (!Compare2JSONValues((JSONObject) json1.get(k1), (JSONObject) json2.get(k2), intflag)) {
							result = false;
							errorMsg += "Key:" + k1;
							errorMsg += " Values in SubJSONObject json1  Does NOT Equal values in SubJSONObject json2";
							errorMsg += "json1:" + ((JSONObject) json1.get(k1)).toString() + " \n\r";
							errorMsg += "json2:" + ((JSONObject) json2.get(k2)).toString() + " \n\r";
							// return result;
							throw new ValueErrorException(errorMsg);
						} else {
							result = true;
							break;
						}
					} else {
						if (!it2.hasNext()) {
							it2 = keys2.iterator();
						}
					}
				} else if (json1.get(k1).getClass().getSimpleName().toString().equals("JSONArray")) {
					intflag++;
					Iterator it3 = ((JSONArray) json1.get(k1)).iterator();
					Iterator it4 = ((JSONArray) json2.get(k2)).iterator();
					JSONObject subjson1 = null;
					JSONObject subjson2 = null;
					while (it3.hasNext()) {
						Object obj1 = it3.next();
						if (obj1.getClass().getSimpleName().equals("JSONObject")) {
							subjson1 = (JSONObject) (obj1);
						}
						it4 = ((JSONArray) json2.get(k2)).iterator();
						while (it4.hasNext()) {
							Object obj2 = it4.next();
							if (obj2.getClass().getSimpleName().equals("JSONObject")) {
								subjson2 = (JSONObject) (obj2);
							} else {
								if (obj1.equals(obj2)) {
									result = true;
									break;
								} else {
									result = false;
									if ((result == false) && (it4.hasNext() == false)) {
										errorMsg += "Values in Array1 Does NOT Equal Values in Array2:\n\r";
										errorMsg += "Array1:" + json1.get(k1);
										errorMsg += "Array2:" + json2.get(k2);
										throw new ValueErrorException(errorMsg);
									}

								}
							}

							if (subjson1 != null && subjson2 != null
									&& Compare2JSONValues(subjson1, subjson2, intflag)) {
								result = true;
								break;
							} else {
								if (!it4.hasNext()) {
									result = false;
									errorMsg += "Values in SubJSON1 Does NOT Equal Values in SubJSON2:\n\r";
									errorMsg += "SubJSON1:" + subjson1 + "\n\r";
									errorMsg += "SubJSON2:" + subjson2 + "\n\r";
									throw new ValueErrorException(errorMsg);
								}
							}
						}
					}
					break;
				} else {
					if (k1.equals(k2)) {
						if (json1.get(k1).equals(json2.get(k2))) {
							result = true;
							break;
						} else if (k1.equals("timestamp")) {
							if (json1.get(k1).toString().length() != 0) {
								result = true;
								break;
							} else {
								result = false;
								errorMsg += "Timestamp for " + k1 + "in json1:" + json1 + "is NULL \n\r";
								throw new ValueErrorException(errorMsg);
							}
						} else {
							result = false;
							if (flag == 0) {
								errorMsg += k1 + " : " + json1.get(k1).toString() + " Does NOT Equal " + k2 + " : "
										+ json2.get(k2).toString() + "\n\r";
								errorMsg += "json1:" + json1.toString();
								errorMsg += "json2:" + json2.toString();
								throw new ValueErrorException(errorMsg);
							}
							return result;
						}
					} else {
						if (!it2.hasNext()) {
							it2 = keys2.iterator();
						}
					}
				}
			}
		}
		return result;
	}

	public static boolean Compare2JSONValues(JSONObject json1, JSONObject json2) throws ValueErrorException {
		boolean result = false;
		result = Compare2JSONValues(json1, json2, 0);
		return result;
	}

	public static boolean Compare2JSONTypes(JSONObject json1, JSONObject json2) throws TypeErrorException {
		boolean result = false;
		String errorMsg = "[Error:Compare2JSONTypes:JSONUtility:]";
		JSONArray keys1, keys2;
		keys1 = json1.names();
		keys2 = json2.names();
		Iterator it1 = keys1.iterator();
		Iterator it2 = keys2.iterator();
		if (keys1.size() == 0) {
			if (keys2.size() == 0) {
				result = true;
				return result;
			} else {
				result = false;
				errorMsg += "JSON1 does NOT equal JSON2 \n\r";
				errorMsg += "JSON1 is NULL" + json1.toString();
				errorMsg += "JSON2 is NOT NULL" + json2.toString();
				throw new TypeErrorException(errorMsg);
			}
		}
		while (it1.hasNext()) {
			String k1 = it1.next().toString();
			while (it2.hasNext()) {
				String k2 = it2.next().toString();
				if (k1.equals(k2)) {
					if (json1.get(k1).getClass().getSimpleName().equals(json2.get(k2).toString())) {
						result = true;
						break;
					} else if (json1.get(k1).getClass().getSimpleName().equals("Integer")
							&& json2.get(k2).toString().toLowerCase().equals("int")) {
						result = true;
						break;
					} else if (k1.toLowerCase().equals("uid")
							&& json2.get(k2).toString().toLowerCase().equals("long")) {
						if (json1.get(k1).getClass().getSimpleName().equals("Integer")) {
							result = true;
							break;
						}
						if (json1.get(k1).getClass().getSimpleName().equals("Long")) {
							result = true;
							break;
						} else {
							result = false;
							errorMsg += "TypeOf  key:" + k1 + " Does Not Equal key:" + k2 + "\n\r";
							errorMsg += "TypeOf key" + k1 + " is " + json1.get(k1).getClass().getSimpleName() + "\n\r";
							errorMsg += "TypeOf key" + k2 + " is " + json2.get(k2).getClass().getSimpleName() + "\n\r";
							throw new TypeErrorException(errorMsg);
						}
					} else if (json1.get(k1).getClass().getSimpleName().equals("JSONObject") && json1.get(k1).getClass()
							.getSimpleName().equals(json2.get(k2).getClass().getSimpleName())) {
						if (Compare2JSONTypes((JSONObject) json1.get(k1), (JSONObject) json2.get(k2))) {
							result = true;
							break;
						} else {
							result = false;
							errorMsg += "TypeOf  key:" + k1 + " Does Not Equal key:" + k2 + "\n\r";
							errorMsg += "JSON1:" + ((JSONObject) json1.get(k1)).toString() + "\n\r";
							errorMsg += "JSON2:" + ((JSONObject) json2.get(k2)).toString() + "\n\r";
							throw new TypeErrorException(errorMsg);
						}
					} else if (json1.get(k1).getClass().getSimpleName().equals("JSONArray") && json1.get(k1).getClass()
							.getSimpleName().equals(json2.get(k2).getClass().getSimpleName())) {
						Iterator it3 = ((JSONArray) json1.get(k1)).iterator();
						Iterator it4 = ((JSONArray) json2.get(k2)).iterator();
						JSONObject subjson1 = null;
						JSONObject subjson2 = null;
						Object obj1 = null, obj2 = null;
						if (json1.get(k1).toString().equals("[]")
								&& json1.get(k1).toString().equals(json2.get(k2).toString().trim())) {
							result = true;
							break;
						} else if ((!json1.getClass().getSimpleName().equals("JSONObject"))
								&& (!json1.get(k1).equals(json2.get(k2)))) {
							result = false;
							errorMsg += "Type in Array1 Does NOT Equal Array2: in the Key:" + k1 + "\n\r";
							errorMsg += "Array1:" + json1.get(k1);
							errorMsg += "Array2:" + json2.get(k2);
							throw new TypeErrorException(errorMsg);
						}
						while (it3.hasNext()) {
							obj1 = it3.next();
							if (obj1.getClass().getSimpleName().equals("JSONObject")) {
								subjson1 = (JSONObject) (obj1);
							}
							it4 = ((JSONArray) json2.get(k2)).iterator();
							while (it4.hasNext()) {
								obj2 = it4.next();
								if (obj2.getClass().getSimpleName().equals("JSONObject")) {
									subjson2 = (JSONObject) (obj2);
								} else {
									if (obj1.getClass().getSimpleName().equals(obj2)) {
										result = true;
										break;
									} else if (obj1.getClass().getSimpleName().equals("Integer")
											&& obj2.toString().toLowerCase().equals("int")) {
										result = true;
										break;
									} else {
										result = false;
										if (!it4.hasNext()) {
											errorMsg += "Type in Array1 Does NOT Equal Array2: in the Key:" + k1
													+ "\n\r";
											errorMsg += "Array1:" + json1.get(k1);
											errorMsg += "Array2:" + json2.get(k2);
											throw new TypeErrorException(errorMsg);
										}
									}
								}
								if (Compare2JSONTypes(subjson1, subjson2)) {
									result = true;
									break;
								} else {
									if (!it4.hasNext()) {
										errorMsg += "Type in Subjson:" + subjson1.toString() + "NOT Equal Subjson:"
												+ subjson2.toString() + "in the Key:" + k1 + "\n\r";
										errorMsg += "JSON1:" + json1.toString() + "\n\r";
										errorMsg += "JSON2:" + json2.toString() + "\n\r";
										throw new TypeErrorException(errorMsg);
									}
								}
							}
						}
					}
					else {
						result = false;
						errorMsg += "TypeOf key:" + k1 + " is " + json1.get(k1).getClass().getSimpleName()
								+ " Doesnot Equal to " + k2 + " : " + json2.get(k2).toString() + "\n\r";
						errorMsg += "JSON1:" + json1.toString() + "\n\r";
						errorMsg += "JSON2:" + json2.toString() + "\n\r";
						throw new TypeErrorException(errorMsg);
					}
				}
			}
		}
		return result;
	}
}
