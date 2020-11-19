package _09_automated_testing_and_tdd.exercise.next_day;

public class NextDayCalculator {
    public static String checkNextDay(int toDay, int toMonth, int toYear) {
        switch (toMonth){
            case 2: {
                boolean isLeap = false;
                if(toYear % 4 == 0) {
                    if( toYear % 100 == 0) {
                        if ( toYear % 400 == 0){
                            isLeap = true;
                        }
                        else{
                            isLeap = false;
                        }
                    }else
                        isLeap = true;
                } else {
                    isLeap = false;
                }
                if(isLeap) {
                    if (toDay < 29) {
                        toDay += 1;
                    } else {
                        toDay = 1;
                        toMonth += 1;
                    }
                }else {
                    if (toDay < 28) {
                        toDay += 1;
                    } else {
                        toDay = 1;
                        toMonth += 1;
                    }
                }
                break;
            }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: {
                if (toDay < 31) {
                    toDay += 1;
                }else {
                    toDay = 1;
                    toMonth += 1;
                }
                break;
            }
            case 12: {
                if (toDay < 31) {
                    toDay += 1;
                }else {
                    toDay = 1;
                    toMonth = 1;
                    toYear += 1;
                }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                if (toDay < 30) {
                    toDay += 1;
                }else {
                    toDay = 1;
                    toMonth += 1;
                }
                break;
            }
        }
        return toDay + "/" + toMonth + "/" + toYear;
    }
}
