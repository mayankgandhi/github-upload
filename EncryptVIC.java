import java.util.ArrayList;

class Main 
{
  public static String noCarryAddition (String t1, String t2)
  {
    //Parsing the Strings
    int x=Integer.parseInt(t1);
    int y=Integer.parseInt(t2);

    int out=0;
    int w=0;
    String sum="";

    //PERFORM NO-CARRY ADDITION
    while(x>0 && y>0)
    {
      w=((x%10)+(y%10))%10;
      x/=10;
      y/=10;
      out=out*10 + w;
    }
    String O = Integer.toString(out);

    for (int i = O.length() - 1 ; i >= 0 ; i--)
      sum = sum + O.charAt(i);

    System.out.println("The noCarryAddition is  " + sum);
    return sum;
  }

  public static String chainAddition(String num, int len)
  {
    //if the string parameter is of length 1
    if(num.length()==1)
    {

    }

    //if the length parameter is smaller than the word itself
    String out = num;
    int i = 0;
    String n1="", n2="";

    while(out.length()<len)
    {
      n1=String.valueOf(out.charAt(i));
      n2=String.valueOf(out.charAt(i+1));
      out+=noCarryAddition(n1, n2);
      i++;
    }
    System.out.println(out);
    return out;
  }

  public static String digitPermutation(String perm)
  {
    //if the string is shorter than 10. return null
    if(perm.length()<10)
    {
      return null;
    }
    String arr=perm;
    char arr1[]=arr.toCharArray();

    int i=0, j=0;

    char a = 'A';
    while(a<='Z')
    {
      for(int x=0;x<perm.length();x++)
      {
        if(perm.charAt(x)==a)
        {
          arr1[x]=(char)(i+'0');
          i++;
        }
      }
      a++;
    }
    String ret = String.valueOf(arr1);
    System.out.println(ret);
    return ret;
  }

  public static ArrayList<String> straddlingCheckerboard (String perm, String anag)
  {
    String res;
    ArrayList<String> sc = new ArrayList<String>();
    //check for conditions for both parameters
    char[] perm1 = new char[10];
    char[] anag1 = new char[10];
    perm1 = perm.toCharArray();
    anag1 = anag.toCharArray();
    char[] pos= new char[2];
    //find the locations of the spacing
    for(int i = 0,j=0; i<10; i++)
    {
      if(anag1[i]==' ')
      {
        pos[j++]=perm1[i];
      }
    }
    int u=0,v=0;
    char[][] list1 = new char[2][10];

    while(u<2)
    {
      while(v<10)
      {
        list1[u][v++]=' ';
      }
      v=0;
      u++;
    }
    u=0;
    v=0;

    boolean found=false;
    for(char a='A';a<='Z'; a++)
    {
      found=false;
      for(int x=0; x<10; x++)
      {
        if(anag1[x]==a) //character found
        {
          found=true;
          sc.add(Character.toString(perm1[x]));
        }
      }
      if(found==false)    //character not found
      {
        list1[u][v]=a;
        if(u==0)
        {
          sc.add(Character.toString(pos[0])+Character.toString(perm1[v]));
        }
        else
        {
          sc.add(Character.toString(pos[1])+Character.toString(perm1[v]));
        }
        v++;
        if(v%10==0)
        {
          u++;
          v=0;
        }
      }
    }
  System.out.println(sc);
  return sc;
}

public static void main(String args[])
{
  straddlingCheckerboard("4071826395","A TIN SHOE");
}

}
