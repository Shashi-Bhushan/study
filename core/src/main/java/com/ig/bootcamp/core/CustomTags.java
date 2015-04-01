package com.ig.bootcamp.core;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomTags extends SimpleTagSupport {

    private String sentence1;
    private String sentence2;

    public String getSentence1() {
        return sentence1;
    }
    public String getSentence2() {
        return sentence2;
    }
    public void setSentence1(String sentence1) {
        this.sentence1 = sentence1;
    }
    public void setSentence2(String sentence2) {
        this.sentence2 = sentence2;
    }
    public void doTag() throws JspException, IOException {
        String sentence;
        sentence=sentence1.concat(sentence2);
        PageContext pageContext=(PageContext)getJspContext();
        JspWriter out =pageContext.getOut();
        out.write(sentence);

    }
   }
