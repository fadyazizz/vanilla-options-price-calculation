import java.math.BigDecimal;
import java.math.RoundingMode;
public class Options {
	
	public static int  counterr(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.visited==false) {
			root.visited=true;
			System.out.println(root.value);
			return 1+counterr(root.left)+counterr(root.right);
		}
		else {
			return counterr(root.left)+counterr(root.right);
		}
		
	}
	
	public static BigDecimal getmax(BigDecimal x,BigDecimal y) {
		if(x.compareTo(y)==1) {
			return x;
		}
		return y;
	}
	
	
	
	
	public static void getvalue(Node root,BigDecimal p,BigDecimal k,BigDecimal r) {
	if(root.right==null && root.left==null && root.visited==false) {
		root.value=getmax(new BigDecimal(0),root.value.subtract(k));
		root.visited=true;
		return;
	}
	if(root.visited==false) {
		
	root.visited=true;
	getvalue(root.right, p, k, r);
	getvalue(root.left,p,k,r);
	root.value=((p.multiply(root.right.value)).add((new BigDecimal(1).subtract(p)).multiply(root.left.value))).divide(r,100,RoundingMode.HALF_UP);
	}
		
	}
	
	
	public static void  navigator(Node root,String s) {
		for(int i=0;i<s.length();i++) {
			if("u".equals(""+s.charAt(i))) {
				root=root.right;
			}
			else {
				root=root.left;
			}
		}
		System.out.println(root.value);
		
	}
	
	public static void main(String[] args) {
		int n=13;
		
		BigDecimal s=new BigDecimal(50);
		s.setScale(3, RoundingMode.HALF_UP);
		BigDecimal u=new BigDecimal(2);
		u.setScale(3, RoundingMode.HALF_UP);
		BigDecimal d=new BigDecimal(0.3);
		d.setScale(3, RoundingMode.HALF_UP);
		BigDecimal k=new BigDecimal(50);
		k.setScale(3, RoundingMode.HALF_UP);
		BigDecimal r=new BigDecimal(1.0);
		r.setScale(3, RoundingMode.HALF_UP);
		MyTree t=new MyTree(n,s,u,d);
		BigDecimal p=(r.subtract(d)).divide((u.subtract(d)));
		
		getvalue(t.root, p, k, r);
		//navigator(t.root, "dd");
		System.out.println(t.root.value.setScale(2,RoundingMode.HALF_UP));
		
		
	
	}

}
