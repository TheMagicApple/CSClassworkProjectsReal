import java.text.DecimalFormat;
public class Rocket {
	static DecimalFormat df=	new DecimalFormat("00.000");
	public static void main(String[] args) {
		float t=0;
		float y=0;
		float v=0;
		float a=0;
		float fd=0;
		
		final float dragco=0.857f;
		final float mass=0.0556f;
		final float thrust=4.45f;
		
		float massb=mass-0.0028f;
		float massc=mass-0.0056f;
		System.out.println("  T     Y     V	    A	  D");
		System.out.println("00.00 00.00 00.00 00.00 00.00");
		float olda=0;
		float oldv=0;
		for(float i=0.01f;i<0.95f;i+=0.01f) {
			t=i;
			fd=dragco*(0.000467f)*v*v;
			a=(float) ((thrust-(massb)*9.81-fd)/massb);
			v+=(a)/1*0.01f;
			olda=a;
			y+=(v)/1*0.01f;
			oldv=v;
			System.out.println(df.format(t)+" "+df.format(y)+" "+df.format(v)+" "+df.format(a)+" "+df.format(fd));
		}
		for(float i=0.96f;i<5.01f;i+=0.01f) {
			t=i;
			fd=dragco*(0.000467f)*v*v;
			a=(float) ((-(massc)*9.81-fd)/massc);
			v+=(a)/1*0.01f;
			olda=a;
			y+=(v)/1*0.01f;
			oldv=v;
			if(v<0)break;
			System.out.println(df.format(t)+" "+df.format(y)+" "+df.format(v)+" "+df.format(a)+" "+df.format(fd));
		}

	}

}
