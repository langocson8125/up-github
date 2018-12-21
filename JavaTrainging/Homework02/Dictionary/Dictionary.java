package GiaiDe3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Dictionary {
	private List<Word> listWord;
	
	public Dictionary() {
		this.listWord = new ArrayList<>();
		this.listWord.add(new Word(1, "dog", "Con chó"));
		this.listWord.add(new Word(2, "car", "Xe hơi"));
		this.listWord.add(new Word(3, "house", "Ngôi nhà"));
		this.listWord.add(new Word(4, "beach", "Bãi biển"));
		this.listWord.add(new Word(5, "chair", "Cái ghế"));
		this.listWord.add(new Word(6, "football", "Bóng đá"));
		this.listWord.add(new Word(7, "teacher", "Giáo viên"));
		this.listWord.add(new Word(8, "run", "Chạy"));
		this.listWord.add(new Word(9, "eyes", "Đôi mắt"));
		this.listWord.add(new Word(10, "cat", "Con mèo"));
	}

	public Word initWord(int id, String en, String vi) {
		return new Word(id, en, vi);
	}
	
	public void addWord(Word obj) {
		this.listWord.add(obj);
	}
	
	private int findWordIndex(String en) {
		// create a comparator
		Comparator<Word> cm = new Comparator<Word>() {
			@Override
		    public int compare(Word w1, Word w2) {
		        return w1.getEn().compareTo(w2.getEn());
		    }
		};
		
		// sort array list by en
		Collections.sort(this.listWord, cm);
		
		// binary search return index of element in sorted arraylist
	    return Collections.binarySearch(this.listWord, new Word(0, en, null), cm);
	}
	
	public Word searchWord(String en) {
		int idFound = this.findWordIndex(en);
		return (idFound > -1) ? this.listWord.get(idFound) : null;
	}

	public List<Word> getListWord() {
		return listWord;
	}

	public void setListWord(List<Word> listWord) {
		this.listWord = listWord;
	}
	
	
}
