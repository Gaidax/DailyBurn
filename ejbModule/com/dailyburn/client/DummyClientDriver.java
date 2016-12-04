package com.dailyburn.client;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.dailyburn.business.*;
import com.dailyburn.entities.FoodItem;

public class DummyClientDriver {
	
	public static void main(String[] args) throws NamingException {
		FoodIteamManageBeanRemote remote = doLookup();
		FoodItem fi = new FoodItem();
		
		fi = remote.getFoodItem(1);
		
		System.out.println(fi.getName());
        
    }
	
	private static final String LOOKUP_STRING = "FoodIteamManageBean/remote";
	
    private static FoodIteamManageBeanRemote doLookup() throws NamingException {
    	
    	final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put("jndi.java.naming.provider.url", "jnp://localhost:9990/");
        jndiProperties.put("jndi.java.naming.factory.url", "org.jboss.naming:org.jnp.interfaces");
        jndiProperties.put("jndi.java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        Context context = new InitialContext(jndiProperties);
        return (FoodIteamManageBeanRemote) context.lookup("ejb:/jboss-as-ejb-remote-app//FoodIteamManageBean!org.jboss.as.quickstarts.ejb.remote.stateless.FoodIteamManageBeanRemote");
    }
    
    private static final String PROVIDER_URL = "jnp://localhost:9990";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
    private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
    private static Context initialContext;
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            // Properties extends HashTable
            Properties prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
            prop.put(Context.PROVIDER_URL, PROVIDER_URL);
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }

}
