public class Solution {
        HashSet<String> cache;
            public boolean isInterleave(String s1, String s2, String s3) {
                        if (s3.length() != s1.length() + s2.length()) { return false;}
                                cache = new HashSet<String>();
                                        return isInterleave(s1, s2, s3, 0);
                                            }

                boolean isInterleave(String s1, String s2, String s3, int index) {
                            String key = makeKey(s1,s2,index);
                                    if (cache.contains(key)) {return false;}

                                            if (index == s3.length()) {
                                                            return true;
                                                                    }

                                                    char keyChar = s3.charAt(index);
                                                            if (s1.length() > 0 && s1.charAt(0) == keyChar) {
                                                                            String newStr = s1.substring(1);
                                                                                        boolean res = isInterleave(newStr, s2, s3, index+1);
                                                                                                    if (res) { return true;}
                                                                                                            }

                                                                    if (s2.length() > 0 && s2.charAt(0) == keyChar) {
                                                                                    String newStr = s2.substring(1);
                                                                                                boolean res = isInterleave(s1, newStr, s3, index+1);
                                                                                                            if (res) { return true;}
                                                                                                                    }
                                                                            cache.add(key);
                                                                                    return false;
                                                                                        }

                    String makeKey(String s1, String s2, int index) {
                                return s1 + "-" + s2 + "-" + index;
                                    }
}
                    }
                                                                    }
                                                            }
                                            }
                }
            }
}
