import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * <p>Created: Mar 2, 2018 11:03:19 AM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.7
 */
public class WhoKeepFish {

    public static void main(String[] args) {
        int size = 5;

        String[] country = {"Ӣ��", "���", "����", "�¹�", "Ų��"}; 
        String[] animal =  {"��", "��", "��", "è", "��"};
        String[] amoke = {"PallMall", "Dunhill", "Blends", "BlueMaster", "Prince"};
        String[] color = {"��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ"};
        String[] drink = {"��", "����", "ţ��", "ơ��", "ˮ"}; 
        
        List<String[]> countryResult = Lists.newArrayList();
        perm(countryResult, country, new String[]{});   // i

        List<String[]> animalResult = Lists.newArrayList();
        perm(animalResult, animal, new String[]{});     // j

        List<String[]> amokeResult = Lists.newArrayList();
        perm(amokeResult, amoke, new String[]{});       // k

        List<String[]> colorResult = Lists.newArrayList();
        perm(colorResult, color, new String[]{});       // l

        List<String[]> drinkResult = Lists.newArrayList();
        perm(drinkResult, drink, new String[]{});       // m
        
        boolean find = false;
        
        
        
        end: for (String[] rowCountry : countryResult) {
            if (!"Ų��".equals(rowCountry[0])) { // Ų����ס��һ�䷿
                continue;
            }
            for (int i = 0; i < size; i ++) {
                for (String[] rowAnimal : animalResult) {
                    find = false;
                    // ���������
                    for (int j = 0; j < size; j ++) {
                        if (rowCountry[j].equals("���") && rowAnimal[j].equals("��")) {
                            find = true;
                            break;
                        }
                    }
                    if (!find) continue;
                    find = false;
                    
                    for (int j = 0; j < size; j ++) {
                        
                        for (String[] rowAmoke : amokeResult) {
                            find = false;
                            for (int k = 0; k < size; k ++) {
                                // ��Pall Mall���̵�������
                                if ("PallMall".equals(rowAmoke[k]) && "��".equals(rowAnimal[k])) {
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) continue;
                            find = false;

                            // ��Blends���̵���ס����è�˵ĸ��ڡ�
                            for (int k = 0; k < size; k ++) {
                                if ("Blends".equals(rowAmoke[k])) {
                                    if (k == 0) {
                                        if ("è".equals(rowAnimal[k + 1])) {
                                            find = true;
                                        }
                                        break;
                                    } else if (k < size - 1) {
                                        if ("è".equals(rowAnimal[k + 1]) || "è".equals(rowAnimal[k - 1])) {
                                            find = true;
                                        }
                                        break;
                                    } else if (k == size - 1) {
                                        if ("è".equals(rowAnimal[k - 1])) {
                                            find = true;
                                        }
                                        break;
                                    }
                                }
                            }
                            if (!find) continue;
                            find = false;
                            
                            // �������ס��Dunhill ���̵��˸���
                            for (int k = 0; k < size; k ++) {
                                if ("Dunhill".equals(rowAmoke[k])) {
                                    if (k == 0) {
                                        if ("��".equals(rowAnimal[k + 1])) {
                                            find = true;
                                        }
                                        break;
                                    } else if (k < size - 1) {
                                        if ("��".equals(rowAnimal[k + 1]) || "��".equals(rowAnimal[k - 1])) {
                                            find = true;
                                        }
                                        break;
                                    } else if (k == size - 1) {
                                        if ("��".equals(rowAnimal[k - 1])) {
                                            find = true;
                                        }
                                        break;
                                    }
                                }
                            }
                            if (!find) continue;
                            find = false;

                            // �¹��˳�Prince����
                            for (int k = 0; k < size; k ++) {
                                if ("Prince".equals(rowAmoke[k]) && "�¹�".equals(rowCountry[k])) {
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) continue;
                            find = false;
                            
                            for (int k = 0; k < size; k ++) {
                                for (String[] rowColor : colorResult) {
                                    find = false;
                                    // Ų����ס��ɫ���Ӹ���
                                    if (!rowColor[1].equals("��ɫ")) {
                                        continue;
                                    }
                                    // ��ɫ�����ڰ�ɫ��������
                                    for (int l = 0; l < size - 1; l ++) {
                                        if ("��ɫ".equals(rowColor[l])) {
                                            if ("��ɫ".equals(rowColor[l + 1])) {
                                                find = true;
                                            }
                                            break;
                                        }
                                    }
                                    
                                    if (!find) continue;
                                    find = false;
                                    
                                    
                                    
                                    // ��ɫ���ӵ����˳�Dunhill ����
                                    for (int l = 0; l < size; l ++) {
                                        if ("��ɫ".equals(rowColor[l]) && "Dunhill".equals(rowAmoke[l])) {
                                            find = true;
                                            break;
                                        }
                                    }
                                    if (!find) continue;
                                    find = false;
                                    
                                    for (int l = 0; l < size; l ++) {
                                        // Ӣ����ס��ɫ����
                                        if ("Ӣ��".equals(rowCountry[l]) && "��ɫ".equals(rowColor[l])) {
                                            for (String[] rowDrink : drinkResult) {
                                                find = false;
                                                // �����˺Ȳ�
                                                for (int m = 0; m < size; m ++) {
                                                    if ("��".equals(rowDrink[m]) && "����".equals(rowCountry[m])) {
                                                        find = true;
                                                        break;
                                                    }
                                                }
                                                if (!find) continue;
                                                find = false;
                                                
                                                // ��ɫ���ӵ����˺ȿ���
                                                for (int m = 0; m < size; m ++) {
                                                    if ("����".equals(rowDrink[m]) && "��ɫ".equals(rowColor[m])) {
                                                        find = true;
                                                        break;
                                                    }
                                                }
                                                if (!find) continue;
                                                find = false;
                                                
                                                // ס���м䷿�ӵ��˺�ţ��
                                                if (!"ţ��".equals(rowDrink[2])) {
                                                    continue;
                                                }
                                                
                                                // ��Blue Master���˺�ơ��
                                                for (int m = 0; m < size; m ++) {
                                                    if ("ơ��".equals(rowDrink[m]) && "BlueMaster".equals(rowAmoke[m])) {
                                                        find = true;
                                                        break;
                                                    }
                                                }
                                                if (!find) continue;
                                                find = false;
                                                
                                                // ��Blends���̵�����һ����ˮ���ھ�
                                                for (int m = 0; m < size; m ++) {
                                                    if ("ˮ".equals(rowDrink[m])) {
                                                        if (m == 0) {
                                                            if ("Blends".equals(rowAmoke[m + 1])) {
                                                                find = true;
                                                            }
                                                            break;
                                                        } else if (m < size - 1) {
                                                            if ("Blends".equals(rowAmoke[m + 1]) || "Blends".equals(rowAmoke[m - 1])) {
                                                                find = true;
                                                            }
                                                            break;
                                                        } else {
                                                            if ("Blends".equals(rowAmoke[m - 1])) {
                                                                find = true;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                }
                                                
                                                if (!find) continue;
                                                find = false;
                                                
                                                
                                                print(rowCountry, "\t\t");
                                                print(rowAnimal, "\t\t");
                                                print(rowAmoke, "\t");
                                                print(rowColor, "\t\t");
                                                print(rowDrink, "\t\t");
                                                
                                                break end;
                                            }
                                        }   
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void print(String[] array, String $t) {
        for (String str : array) {
            System.err.print("|" + String.format("%11s", str) + "|\t");
        }
        System.err.println();
    }
    
    /*
     * ��ʾ��Ӣ����ס��ɫ���ӡ�����������������˺Ȳ衢��ɫ�����ڰ�ɫ�������桢��ɫ���ӵ����˺ȿ��ȡ�
     * ��Pall Mall���̵������񡢻�ɫ���ӵ����˳�Dunhill ���̡�
     * ס���м䷿�ӵ��˺�ţ�̡� Ų����ס��һ�䷿����Blends���̵���ס����è�˵ĸ��ڡ�
     * �������ס��Dunhill ���̵��˸��ڡ���Blue Master���˺�ơ�ơ�
     * �¹��˳�Prince���̡�Ų����ס��ɫ���Ӹ��ڡ���Blends���̵�����һ����ˮ���ھӡ�
     */
    public static void perm(List<String[]> result, String[] arr, String[] m) {
        if (arr.length == 0) {
            //result = System.arraycopy(reult, srcPos, dest, destPos, length);
            result.add(m);
        } else {
            for (int i = 0; i < arr.length; i ++) {
                String[] copy = new String[arr.length];
                System.arraycopy(arr, 0, copy, 0, arr.length);
                
                String a = copy[i];
                String b = copy[0];
                copy[0] = a;
                copy[i] = b;
                
                String[] curr = new String[copy.length - 1];
                System.arraycopy(copy, 1, curr, 0, curr.length);
                
                String[] next = Arrays.copyOf(m, m.length + 1);
                
                
                next[next.length - 1] = arr[i];
                
                perm(result, curr, next);
            }
        }
    }
    
}


// output:
|        Ų��|    |        ����|    |         Ӣ��|    |       �¹�|    |         ���|	
|          è|    |         ��|     |          ��|    |         ��|    |           ��|	
|     Dunhill|    |     Blends|    |    PallMall|    |     Prince|    |   BlueMaster|	
|        ��ɫ|    |        ��ɫ|    |        ��ɫ|    |        ��ɫ|   |          ��ɫ|	
|          ˮ|    |          ��|    |        ţ��|    |        ����|   |         ơ��|	
