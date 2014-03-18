/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class IntergerTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "6hAFlm%5622422_%43t%e846E131E5-t%mei2E89F3F415_%h333f5b7-%8Ent25..F%1%3512%El3_D%%%23415%-upF.xc2235897357.Fk75559d93E5%l%%fio9F8E1677E8mae5EEE%379%E5l32iam%15%5%2293puy849b54155%E";
		System.out.println(s.length());
		System.out.println(getLocation(s));
		Integer integer = 12;
		change(integer);
		System.out.println(integer);
	}

	private static void change(Integer integer) {
		integer = 50;
	}

	public static String getLocation(String location)
			throws UnsupportedEncodingException {
		int _local10;
		int _local2 = Integer.parseInt(location.substring(0, 1));
		String _local3 = location.substring(1, location.length());
		double _local4 = Math.floor(_local3.length() / _local2);
		int _local5 = _local3.length() % _local2;
		String[] _local6 = new String[_local2];
		int _local7 = 0;
		while (_local7 < _local5) {
			if (_local6[_local7] == null) {
				_local6[_local7] = "";
			}
			_local6[_local7] = _local3.substring(
					(((int) _local4 + 1) * _local7),
					(((int) _local4 + 1) * _local7) + ((int) _local4 + 1));
			_local7++;
		}
		_local7 = _local5;
		while (_local7 < _local2) {
			_local6[_local7] = _local3
					.substring(
							(((int) _local4 * (_local7 - _local5)) + (((int) _local4 + 1) * _local5)),
							(((int) _local4 * (_local7 - _local5)) + (((int) _local4 + 1) * _local5))
									+ (int) _local4);
			_local7++;
		}
		String _local8 = "";
		_local7 = 0;
		while (_local7 < ((String) _local6[0]).length()) {
			_local10 = 0;
			while (_local10 < _local6.length) {
				if (_local7 >= _local6[_local10].length()) {
					break;
				}
				_local8 = (_local8 + _local6[_local10].charAt(_local7));
				_local10++;
			}
			_local7++;
		}
		_local8 = URLDecoder.decode(_local8, "utf8");
		String _local9 = "";
		_local7 = 0;
		while (_local7 < _local8.length()) {
			if (_local8.charAt(_local7) == '^') {
				_local9 = (_local9 + "0");
			} else {
				_local9 = (_local9 + _local8.charAt(_local7));
			}
			;
			_local7++;
		}
		_local9 = _local9.replace("+", " ");
		return _local9;
	}

}
