package com.drguildo.dailyprogrammer.easy;

public class SimpleDecoder {
  public static void main(String[] args) {
    String s = "Etvmp$Jsspw%%%%[e}$xs$ks%$]sy$lezi$wspzih$xli$lmhhir$qiwweki2$Rs{$mx$mw$}syv$xyvr$xs$nsmr\n"
        + "mr$sr$xlmw$tvero2$Hs$rsx$tswx$er}xlmrk$xlex${mpp$kmzi$e{e}$xlmw$qiwweki2$Pix\n"
        + "tistpi$higshi$xli$qiwweki$sr$xlimv$s{r$erh$vieh$xlmw$qiwweki2$]sy$ger$tpe}$epsrk\n"
        + "f}$RSX$tswxmrk$ls{$}sy$higshih$xlmw$qiwweki2$Mrwxieh$tswx$}syv$wspyxmsr$xs$fi$}syv\n"
        + "jezsvmxi$Lipps${svph$tvskveq$mr$sri$perkyeki$sj$}syv$glsmgi2$\n"
        + "Qeoi$wyvi$}syv$tvskveq$we}w$&Lipps$[svph%%%&${mxl$7$%$ex$xli$irh2$Xlmw${e}\n"
        + "tistpi$fvs{wmrk$xli$gleppirki${mpp$xlmro${i$lezi$epp$pswx$syv$qmrhw2$Xlswi${ls$tswx$lipps\n"
        + "{svph$wspyxmsrw${mxlsyx$xli$xlvii$%%%${mpp$lezi$rsx$higshih$xli$qiwweki$erh$ws$}sy$ger$\n"
        + "tspmxip}$tsmrx$syx$xlimv$wspyxmsr$mw$mr$ivvsv$,xli}$evi$nywx$jspps{mrk$epsrk${mxlsyx$ors{mrk-\n"
        + "Irns}$xlmw$jyr2$Xli$xvyxl${mpp$fi$liph$f}$xlswi${ls$ger$higshi$xli$qiwweki2$>-";
    String d = "";

    for (char c : s.toCharArray()) {
      if (c == '\n') {
        System.out.println(d);
        d = "";
      } else {
        d = d + (char) (((int) c) - 4);
      }
    }
  }
}
