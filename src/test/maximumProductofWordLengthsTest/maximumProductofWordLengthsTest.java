package test.maximumProductofWordLengthsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class maximumProductofWordLengthsTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		assertEquals(true, validation(words));
		assertEquals(25, maxProduct(words));
		
		String[] words2 = {"a","ab","abc","d","cd","bcd","abcd"};
		assertEquals(true, validation(words2));
		assertEquals(5, maxProduct(words2));
		
		String[] words3 = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
		assertEquals(true, validation(words3));
		assertEquals(15, maxProduct(words3));
		
	}
	
	private int maxProduct(String[] words) {
        
		int reuslt = 0;
		
		if(!validation(words))
        	return reuslt;
		
		List<String> wordList = Stream.of(words).distinct()
												.sorted(Comparator.comparingInt(String::length).reversed())
												.collect(Collectors.toList());
		
		for(int i=0; i<wordList.size(); i++) {
			
//			if(reuslt > 0) break;
			
			for(int j=0; j<wordList.size(); j++) {
				if(i == j) continue;
				
				if(wordList.get(i).length() == wordList.get(j).length()) {
					if(!wordContains(wordList.get(i), wordList.get(j))) {
						reuslt += resultLength(wordList.get(i), wordList.get(j));
						wordList.remove(i);
						wordList.remove(j-1);
					}
				}
			}
		}
		
        return reuslt;
    }
    
    private boolean validation(String[] words){
        Stream<String> wordList = Stream.of(words);
 
        if(words.length > 1000 || words.length < 2) return false;
        
        if(wordList.filter(word -> word.length() > 1000 || word.length() < 1 || !word.matches("^[a-z]*$")).findFirst().isPresent()) return false;
        
        return true;
    }
    
    private boolean wordContains(String word1, String word2) {
    	
    	char[] word2List = word2.toCharArray();
    	char[] word1List = word1.toCharArray();
    	
//    	return Stream.of(word1List).filter(tmpWord1 -> Stream.of(word2List).filter(tmpWord2 -> tmpWord1 == tmpWord2)
//    																	   .findFirst()
//    																	   .isPresent())
//   					 .findFirst()
//   					 .isPresent();
    	
    	for(char w1 : word1List) {
    		for(char w2 : word2List) {
    			if(w1 == w2)
    				return true;
    		}
    	}
    	
    	return false;
    	
    }
    
    private int resultLength(String word1, String word2) {
    	return word1.length() * word2.length();
    }
    

}
