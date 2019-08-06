package com.snow87;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static String data = "From off a hill whose concave womb reworded\\r\\n  A plaintful story from a sist'ring vale,\\r\\n  My spirits t'attend this double voice accorded,\\r\\n  And down I laid to list the sad-tuned tale,\\r\\n  Ere long espied a fickle maid full pale,\\r\\n  Tearing of papers, breaking rings atwain,\\r\\n  Storming her world with sorrow's wind and rain.\\r\\n\\r\\n  Upon her head a platted hive of straw,\\r\\n  Which fortified her visage from the sun,\\r\\n  Whereon the thought might think sometime it saw\\r\\n  The carcase of a beauty spent and done.\\r\\n  Time had not scythed all that youth begun,\\r\\n  Nor youth all quit, but spite of heaven's fell rage\\r\\n  Some beauty peeped through lattice of seared age.\\r\\n\\r\\n  Oft did she heave her napkin to her eyne,\\r\\n  Which on it had conceited characters,\\r\\n  Laund'ring the silken figures in the brine\\r\\n  That seasoned woe had pelleted in tears,\\r\\n  And often reading what contents it bears;\\r\\n  As often shrieking undistinguished woe,\\r\\n  In clamours of all size, both high and low.\\r\\n\\r\\n  Sometimes her levelled eyes their carriage ride,\\r\\n  As they did batt'ry to the spheres intend;\\r\\n  Sometime diverted their poor balls are tied\\r\\n  To th' orbed earth; sometimes they do extend\\r\\n  Their view right on; anon their gazes lend\\r\\n  To every place at once, and nowhere fixed,\\r\\n  The mind and sight distractedly commixed.\\r\\n\\r\\n  Her hair, nor loose nor tied in formal plat,\\r\\n  Proclaimed in her a careless hand of pride;\\r\\n  For some, untucked, descended her sheaved hat,\\r\\n  Hanging her pale and pined cheek beside;\\r\\n  Some in her threaden fillet still did bide,\\r\\n  And, true to bondage, would not break from thence,\\r\\n  Though slackly braided in loose negligence.\\r\\n\\r\\n  A thousand favours from a maund she drew\\r\\n  Of amber, crystal, and of beaded jet,\\r\\n  Which one by one she in a river threw,\\r\\n  Upon whose weeping margent she was set;\\r\\n  Like usury applying wet to wet,\\r\\n  Or monarchs' hands that lets not bounty fall\\r\\n  Where want cries some, but where excess begs all.\\r\\n\\r\\n  Of folded schedules had she many a one,\\r\\n  Which she perused, sighed, tore, and gave the flood;\\r\\n  Cracked many a ring of posied gold and bone,\\r\\n  Bidding them find their sepulchres in mud;\\r\\n  Found yet moe letters sadly penned in blood,\\r\\n  With sleided silk feat and affectedly\\r\\n  Enswathed and sealed to curious secrecy.\\r\\n\\r\\n  These often bathed she in her fluxive eyes,\\r\\n  And often kissed, and often 'gan to tear;\\r\\n  Cried, 'O false blood, thou register of lies,\\r\\n  What unapproved witness dost thou bear!\\r\\n  Ink would have seemed more black and damned here!\\r\\n  This said, in top of rage the lines she rents,\\r\\n  Big discontents so breaking their contents.\\r\\n\\r\\n  A reverend man that grazed his cattle nigh,\\r\\n  Sometime a blusterer that the ruffle knew\\r\\n  Of court, of city, and had let go by\\r\\n  The swiftest hours observed as they flew,\\r\\n  Towards this afflicted fancy fastly drew;\\r\\n  And, privileged by age, desires to know\\r\\n  In brief the grounds and motives of her woe.\\r\\n\\r\\n  So slides he down upon his grained bat,\\r\\n  And comely distant sits he by her side;\\r\\n  When he again desires her, being sat,\\r\\n  Her grievance with his hearing to divide.\\r\\n  If that from him there may be aught applied\\r\\n  Which may her suffering ecstasy assuage,\\r\\n  'Tis promised in the charity of age.\\r\\n\\r\\n  'Father,' she says, 'though in me you behold\\r\\n  The injury of many a blasting hour,\\r\\n  Let it not tell your judgement I am old:\\r\\n  Not age, but sorrow, over me hath power.\\r\\n  I might as yet have been a spreading flower,\\r\\n  Fresh to myself, if I had self-applied\\r\\n  Love to myself, and to no love beside.\\r\\n\\r\\n  'But woe is me! too early I attended\\r\\n  A youthful suit- it was to gain my grace-\\r\\n  O, one by nature's outwards so commended\\r\\n  That maidens' eyes stuck over all his face.\\r\\n  Love lacked a dwelling and made him her place;\\r\\n  And when in his fair parts she did abide,\\r\\n  She was new lodged and newly deified.\\r\\n\\r\\n  'His browny locks did hang in crooked curls;\\r\\n  And every light occasion of the wind\\r\\n  Upon his lips their silken parcels hurls.\\r\\n  What's sweet to do, to do will aptly find:\\r\\n  Each eye that saw him did enchant the mind;";


    public static void main(String[] args) {
        BobbertSort rs = new BobbertSort();
        List<String> data = new ArrayList<>(List.of(Main.data.split(" ")));
        for (int i = 0; i < 14; i++) {
            data.addAll(data);
        }
        long totalChars = 0;
        for(String s : data){
            totalChars += s.length();
        }
        System.out.println("Total values: "+data.size());
        System.out.println("Total chars:  "+totalChars);
        long rankSortTime = 0;
        List<String> rankSortedResult;
        long startTime = System.currentTimeMillis();
        rankSortedResult = rs.sort(data);
        rankSortTime += System.currentTimeMillis() - startTime;

        System.out.println("Bobbert sort time: " + (rankSortTime));

        long collectionSortTime = 0;
        startTime = System.currentTimeMillis();
        Collections.sort(data);
        collectionSortTime += System.currentTimeMillis() - startTime;
        System.out.println("Collection sort time: " + (collectionSortTime));

        assert rankSortedResult.size() == data.size();
        for (int i = 0; i < rankSortedResult.size(); i++) {
            if (!rankSortedResult.get(i).equals(data.get(i))) {
                throw new RuntimeException("list not sorted!");
            }
        }
    }
}
