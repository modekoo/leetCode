package test.findFirstPalindromicStringintheArrayTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class findFirstPalindromicStringintheArrayTest {

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		String[] testWords = {"umicrszeaswtfmctwvoogehszwdjrwdcgyxxetbzevxrqphubyqbgpfetguyv","vzdzfwyevkvqhmvqssnvpayihawydzcovzmh","drvqqepesvornphmikbimxennygxisdysssmxjmaaecaqiwdgfxitoopigxauoojsebjmbcrymvpnnfomlkg","vvszfvtykdyfiywxgxmjpcawzdaovbujmexggwczovhspkrdsskxzrpgfaspnbncdspktcyfkkshpyojwwlysizd","epdtgfhgninnwqzztwm","dmhynaogcxyaxsghzjwzyqfuwyinstxoqcdkxeobinpqeplw","ruhxgdrzfyqyqmxclfqosyczqapiizxlzgixdxthhrv","dwcblqnxtrwtqmtqenidhxnifdbmdvobwmcvwjxgbyjzgvrqzlskjbfirauguhyyjhlotuckssrkqzppzbqd","gxdq","paesyowqeguvxozbixjqppeagycjx","glstauwugkidegnllapgzbzchckepmhbameuigsiqywbilwolxuwzzjwzouqknhlkbjzejxtponmkqjlojurxnryxyqy","inyhioiwanafuhsprudtkqztoakxhbmqcmibsxlhycbmqrvtfabsncmiymthcxwkwkq","djknenppuleedpptrfjgqfejcoghnxjlvjalxkyvnujgiiwdbtvgqvgsivkzqcrbfcvooyhqmrlacyiozytmampjwpknrj","zzrpjoogwkdmdxdkdwgwugqtmzryrgtelnvydyqewpdzzptqzvffppgnhhcaiqotmyslntlwjajzuzbawidpxjtyxryg","xmegifttkamzbpjqbghgwdrkvtnuwfmjdmwehdqiyvgpxxlbkcvkemjbmhbyeqyfssytuwaeysvgnidhcgpncxdxxzhrkbvyqfrs","wgljaiyhyfdijjgihseciabfcoqfojhswewpkpartzmaaglvdfifpptycyonigwcgyklapzojivgojcrevugspejmwanolg","oceurgzgvvctgydqexhghwcochhmtoxjugreqfdnsshffngchetrwedhinosdhwlgviohpkjowr","dyl","vjxkcihfmnmmz","aheg","dwsomlqmaqifihkwahvywzqamgominhxfsgrgbgvoiopnikhxonpetelfsguvhxgiujrij","pdrjgfqzyqczpwdsfzypgkmsvnpboutmcffqrwuzkchaufymmczrdwulbvbanungpxqk","eudbizaabgfzqytowifsuovmxmkjgajtliyfycbrkxeaarakapqoihawmdzmglfnglpwqnfd","txdclnfwxevu","kslqrafjshhadqszeljcekrpnpxqgppbnadmzmpufvadcghxqdqmafpbnutifigstxyilmgx","yhhvhyoolv","sjtubggxcla","vydf"};
		
		String result = firstPalindrome(testWords);
		assertEquals("dwcblqnxtrwtqmtqenidhxnifdbmdvobwmcvwjxgbyjzgvrqzlskjbfirauguhyyjhlotuckssrkqzppzbqd", result);
	}

	@Test
	private String firstPalindrome(String[] words) {
		
		String resultStr = "";
		
		if(!validation(words))
			return resultStr;
		
		for(String word : words) {
			char[] temp = word.toCharArray();
			char[] temp2= new char[temp.length];
			
			for(int i =0; i<temp2.length; i++) {
				temp2[i] = temp[temp2.length - i - 1];
			}
			
			String reversWordStr = new String(temp2);
			if(word.equals(reversWordStr)) {
				resultStr = word;
				break;
			}
		}
		
		return resultStr;
    }
	
	private boolean validation(String[] words) {
		
		if(words.length > 100 || words.length < 1)
			return false;
		
		if(Stream.of(words).filter(word -> word.length() < 1 || word.length() > 1000 || !word.matches("^[a-z]*$")).findFirst().isPresent())
			return false;
		
		return true;
	}
	
	

}
