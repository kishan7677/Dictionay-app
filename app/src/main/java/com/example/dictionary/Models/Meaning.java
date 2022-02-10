package com.example.dictionary.Models;

import java.util.List;

public class Meaning {
   String partOfSpeech= "";
   List<Definition> definitions=null;

   public String getPartOfSpeech() {
      return partOfSpeech;
   }

   public void setPartOfSpeech(String partOfSpeech) {
      this.partOfSpeech = partOfSpeech;
   }

   public List<Definition> getDefinitions() {
      return definitions;
   }

   public void setDefinitions(List<Definition> definitions) {
      this.definitions = definitions;
   }
}
