package com.ssh.action;

import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameAction extends ActionSupport {
  int gnum;

  Log logger = LogFactory.getLog(GameAction.class);
  final static String start = "start";
  final static String guess = "guess";
  final Random random = new Random();

  public String game() {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    Object gametime = session.get("gametime");
    if (gametime == null) {
      session.put("gametime", 1);
      int result = random.nextInt(100) + 1;
      session.put("num", result);
      return start;
    } else {
      session.remove("guesstime");
      session.remove("large");
      session.remove("lastnum");
      int gametimeInt = (int) gametime;
      gametimeInt++;
      session.put("gametime", gametimeInt);
      int result = random.nextInt(100) + 1;
      session.put("num", result);
      return start;
    }
  }

  public String guess() {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    Object gametime = session.get("gametime");
    if (gametime == null) {
      logger.error("error in guess");
    } else {
      Object guesstime = session.get("guesstime");
      if (guesstime == null) {
        session.put("guesstime", 1);
    
      } else {
        session.put("guesstime", (int) guesstime + 1);
      }
      int num = (int) session.get("num");
      int large;
      if (gnum > num) {
        large = 1;
      } else if (gnum < num) {
        large = -1;
      } else {
        large = 0;
      }
      session.put("large", large);
      session.put("lastnum", gnum);
      
    }
    return guess;
  }

  public int getGnum() {
    return gnum;
  }

  public void setGnum(int gnum) {
    this.gnum = gnum;
  }

}
