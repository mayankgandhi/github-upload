import java.util.ArrayList;

public class VICOperations
{
  public static String noCarryAddition (String t1, String t2)
  {
    int res=0,x=0;
    String out="";
    if(t2.length()>=t1.length())
    {
      x=t2.length();
    }
    else
    {
      x=t1.length();
    }
    for(int i=0;i<x;i++)
    {
      res = (Character.getNumericValue(t1.charAt(i))+Character.getNumericValue(t2.charAt(i)))%10;
      out=out+Integer.toString(res);
    }
    System.out.println("The noCarryAddition is  " + out);
    return out;
  }

  // public static String noCarryAddition (String t1, String t2)
  // {
  //   System.out.println("first: "+t1+"  second: "+t2);
  //   //Parsing the Strings
  //   double x=Double.parseDouble(t1);
  //   double y=Double.parseDouble(t2);

  //   int out=0;
  //   int w=0;
  //   String sum="";

  //   //PERFORM NO-CARRY ADDITION
  //   while(x>0 && y>0)
  //   {
  //     w=(int)((x%10==0?x:x%10)+(y%10==0?y:y%10))%10;
  //     x=((int)x)/10;
  //     y=((int)y)/10;
  //     out=out*10 + w;
  //   }
  //   String O = Integer.toString(out);

  //   for (int i = O.length() - 1 ; i >= 0 ; i--)
  //     sum = sum + O.charAt(i);

  //   System.out.println("The noCarryAddition is  " + sum);
  //   return sum;
  // }

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
      if(i<out.length()-1)
      {
        n1=String.valueOf(out.charAt(i));
        n2=String.valueOf(out.charAt(i+1));
        out+=noCarryAddition(n1, n2);
        i++;
      }
    }

    System.out.println("The chainAddition is  " + out);
    return out;
  }

  public static String digitPermutation(String perm1)
  {
    int count=10;
    String arr="", ret="";
    String perm="";
     //if the string is shorter than 10. return null
    if(perm1.length()<10)
    {
      return null;
    }
    else if(perm1.length()>10)
    {
      for(int i=0;i<perm1.length();i++)
      {
        if(count==0)
          break;

        if(perm1.charAt(i)!=' ')
        {
          perm+=Character.toString(perm1.charAt(i));
          count--;
        }
      }
    }
    int i=0, j=0;
    if(Character.isLetter(perm1.charAt(0)))
    {
      perm=perm.toUpperCase();
      arr=perm;
      char arr1[]=arr.toCharArray();

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
      ret = String.valueOf(arr1);
      System.out.println(ret);
      return ret;
    }
    arr=perm;
    char arr1[]=arr.toCharArray();
    char a = '0';
    while(a<='9')
    {
      for(int x=0;x<perm.length();x++)
      {
        if(perm.charAt(x)==a)
        {
          arr1[x]=(char)(i+'0');
          i++;
          System.out.print("'"+arr1[x]+"'");
        }
      }
      a++;
    }
    ret = String.valueOf(arr1);
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
  
}