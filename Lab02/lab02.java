import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class lab02 {
    static public int[] readArray(int length, Scanner in) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = in.nextInt();
        }
        return result;
    }

    static public int sum(ArrayList<Integer> arr) {
        int result = 0;
        for (int a : arr) {
            result += a;
        }
        return result;
    }

    static public ArrayList<Integer> delAllZerosFromArray(ArrayList<Integer> seq, int index) {
        for (int i = index; i < seq.size(); i++) {
            if (seq.get(i) == 0) {
                seq.remove(i);
                i--;
            }
        }
        return seq;
    }

    static public ArrayList<Integer> createRandom(int lenght) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        for (int i = 0; i < lenght; i++) {
            result.add(i, randomGenerator.nextInt(2));
        }
        return result;
    }

    static public ArrayList<Integer> copyArray(ArrayList<Integer> seq) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < seq.size(); i++) {
            result.add(i, seq.get(i));
        }
        return result;
    }

    static public void cleanUp(ArrayList<Integer> firstSequence, ArrayList<Integer> secondSequence, int firstSum, int secondSum) {
        if (firstSequence.size() == secondSequence.size()) {
            if (firstSum != secondSum) {
                while (firstSum > secondSum) {
                    firstSequence.remove(firstSequence.size() - 1);
                    secondSequence.remove(0);
                    firstSum--;
                }
                while (secondSum > firstSum) {
                    secondSequence.remove(secondSequence.size() - 1);
                    firstSequence.remove(0);
                    secondSum--;
                }
            }
        } else {
            while (firstSum > secondSum) {
                firstSequence.remove(firstSequence.size() - 1);
                firstSum--;
            }
            while (secondSum > firstSum) {
                secondSequence.remove(secondSequence.size() - 1);
                secondSum--;
            }
            while (firstSequence.size() > secondSequence.size()) {
                firstSequence.remove(0);
            }
            while (firstSequence.size() < secondSequence.size()) {
                secondSequence.remove(0);
            }
        }
    }

    static public void resize(ArrayList<Integer> firstSequence, ArrayList<Integer> secondSequence, int firstSum, int secondSum) {
        if (firstSum != secondSum) {
            while (firstSum > secondSum) {
                for (int i = 0; i < firstSequence.size(); i++) {
                    if (firstSequence.get(i) == 1) {
                        firstSequence.remove(i);
                        firstSum--;
                        break;
                    }
                }
            }
            while (firstSum < secondSum) {
                for (int i = 0; i < secondSequence.size(); i++) {
                    if (secondSequence.get(i) == 1) {
                        secondSequence.remove(i);
                        secondSum--;
                        break;
                    }
                }
            }
        }
        while (firstSequence.size() > secondSequence.size()) {
            for (int i = 0; i < firstSequence.size(); i++) {
                if (firstSequence.get(i) == 0) {
                    firstSequence.remove(i);
                    break;
                }
            }
        }
        while (firstSequence.size() < secondSequence.size()) {
            for (int i = 0; i < secondSequence.size(); i++) {
                if (secondSequence.get(i) == 0) {
                    secondSequence.remove(i);
                    break;
                }
            }
        }
    }

    static public int twoCases(ArrayList<Integer> firstSequence, ArrayList<Integer> secondSequence, int i) {
        int temp = 0;
        ArrayList<Integer> firstSequenceTemp = delAllZerosFromArray(copyArray(firstSequence), i + 1);
        ArrayList<Integer> secondSequenceTemp = delAllZerosFromArray(copyArray(secondSequence), i);
        deleteOnesUntilIndex(firstSequenceTemp, i);
        deleteOnesUntilIndex(secondSequenceTemp, i);
        cleanUp(firstSequenceTemp, secondSequenceTemp, sum(firstSequenceTemp), sum(secondSequenceTemp));
        temp = firstSequenceTemp.size();
        ArrayList<Integer> firstSequenceCopy = copyArray(firstSequence);
        ArrayList<Integer> secondSequenceCopy = copyArray(secondSequence);
        firstSequenceCopy.remove(i);
        int other = process(firstSequenceCopy, secondSequenceCopy);
        if (other > temp) {
            temp = other;
        }
        return temp;
    }

    static public void deleteOnesUntilIndex(ArrayList<Integer> seq1, int index) {
        for (int i = 0; i < index; i++) {
            if (seq1.get(i) == 1) {
                seq1.remove(i);
                i--;
                index--;
            }
        }
    }

    static public Boolean checkIfCorrect(ArrayList<Integer> seq1, ArrayList<Integer> seq2) {
        Boolean flag = false;
        for (int i = 0; i < seq1.size(); i++) {
            if (seq1.get(i) != seq2.get(i)) {
                return false;
            }
            if (!flag && seq1.get(i) == 1 && seq1.get(i) == 1) {
                flag = true;
            }
            if (flag && (seq1.get(i) == 0)) {
                return false;
            }
        }
        return true;
    }

    static public int process(ArrayList<Integer> seq1, ArrayList<Integer> seq2) {
        int max = 0;
        int sum1 = sum(seq1);
        int sum2 = sum(seq2);
        if (seq1.size() != seq2.size()) {
            resize(seq1, seq2, sum1, sum2);
            sum1 = sum(seq1);
            sum2 = sum(seq2);
        }
        for (int i = 0; i < seq1.size(); i++) {
            int temp = 0;
            if (seq1.get(i) == 0 && seq2.get(i) == 0) {
                if (i < seq1.size() - 1) {
                    ArrayList<Integer> seq1_temp = delAllZerosFromArray(copyArray(seq1), i + 1);
                    ArrayList<Integer> seq2_temp = delAllZerosFromArray(copyArray(seq2), i + 1);
                    deleteOnesUntilIndex(seq1_temp, i);
                    deleteOnesUntilIndex(seq2_temp, i);
                    cleanUp(seq1_temp, seq2_temp, sum(seq1_temp), sum(seq2_temp));
                    temp = seq1_temp.size();
                } else {
                    if (checkIfCorrect(seq1, seq2)) {
                        temp = seq1.size();
                    }
                }
            } else if (seq1.get(i) == 1 && seq2.get(i) == 0) {
                temp = twoCases(seq1, seq2, i);
            } else if (seq1.get(i) == 0 && seq2.get(i) == 1) {
                temp = twoCases(seq2, seq1, i);
            } else {
                ArrayList<Integer> firstSequenceTemp = delAllZerosFromArray(copyArray(seq1), i + 1);
                ArrayList<Integer> secondSequenceTemp = delAllZerosFromArray(copyArray(seq2), i + 1);
                deleteOnesUntilIndex(firstSequenceTemp, i);
                deleteOnesUntilIndex(secondSequenceTemp, i);
                cleanUp(firstSequenceTemp, secondSequenceTemp, sum(firstSequenceTemp), sum(secondSequenceTemp));
                temp = firstSequenceTemp.size();
                ArrayList<Integer> copyFirstSequence = copyArray(seq1);
                ArrayList<Integer> copySecondSequence = copyArray(seq2);
                copyFirstSequence.remove(i);
                copySecondSequence.remove(i);
                int other = process(copyFirstSequence, copySecondSequence);
                if (other > temp) {
                    temp = other;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    static public void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int lenght = 4;
        ArrayList<Integer> firstSequence = createRandom(lenght);
        ArrayList<Integer> secondSequence = createRandom(lenght);
        System.out.println(firstSequence + " " + secondSequence);
        System.out.println(process(firstSequence, secondSequence));
        in.close();
    }
}