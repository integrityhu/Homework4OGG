/* Cortado - a video player java applet
 * Copyright (C) 2004 Fluendo S.L.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Street #330, Boston, MA 02111-1307, USA.
 */

package com.fluendo.examples;

import com.fluendo.player.*;
import java.awt.*;

public class Player extends Frame {
  private static final long serialVersionUID = 1L;
  private static final int window_width = 352;
  private static final int window_height = 270;
  Cortado applet;
//http://87.229.109.104:8090/cam1.ogg (Bp Állatkert elefánt kifutó)
//http://people.xiph.org/~maikmerten/demos/BigBuckBunny.ogv (Kövér Buck a nyuszi)
  public Player(String url) {
    applet = new Cortado();
    applet.setSize(window_width, window_height);
    setSize(window_width, window_height);

    applet.setParam ("url", url);
    applet.setParam ("local", "false");
    //applet.setParam ("seekable", "true");
    //applet.setParam ("duration", "00352");
    applet.setParam ("framerate", "60");
    applet.setParam ("keepaspect", "true");
    applet.setParam ("video", "true");
    applet.setParam ("audio", "true");
    applet.setParam ("kateIndex", "0");
    //applet.setParam ("kateLanguage", "en");
    //applet.setParam ("kateCategory", "SUB");
    //applet.setParam ("audio", "false");
    applet.setParam ("bufferSize", "200");
    applet.setParam ("userId", "wim");
    applet.setParam ("password", "taymans");

    add(applet);
    show();

    applet.init();
    applet.start();
  }

  public static void main(String args[]) {
    Player p;

    if (args.length < 1) {
      System.out.println ("usage: Player <uri>");
      return;
    }

    p = new Player(args[0]);
    
    synchronized (p) {
      try {
        p.wait ();
      }
      catch (InterruptedException ie) {}
    }
  }
}
