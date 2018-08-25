package leetcode;

import java.util.*;

class Codec_3 {

	List<String> list = new ArrayList<String>();
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		list.add(longUrl);
		return "http://tinyurl.com/" + (list.size() - 1);
	}
	
	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return list.get(Integer.parseInt(shortUrl.substring(19)));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));