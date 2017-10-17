package com.statravel.ds.iolet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.statravel.ds.common.DSConfig;

import de.reddot.api.app.io.IoletRequest;
import de.reddot.api.app.io.IoletResponse;
import de.reddot.api.app.io.IoletResponseFactory;
import de.reddot.api.app.iolet.IoletAdapter;
import de.reddot.api.common.session.CoaSession;

/**
 * Provides following iolet parameters for node server requests
 * 
 *  components/top-offers
 *  
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
     <pos>UK</pos>
     <module>components/top-offers</module>
     <titleLabel>Flights to</titleLabel>
     <currency>&pound;</currency>
     <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 * 
 *  components/blue-tickets
 *  
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
     <pos>UK</pos>
     <module>components/blue-tickets</module>
     <currency>&pound;</currency>
     <pageType>city</pageType>
     <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

<rde-dm:iolet name="nodeModules" method="GetModule" value="India">
	...
     <pageType>country</pageType>
</rde-dm:iolet>

<rde-dm:iolet name="nodeModules" method="GetModule" value="E">
	...
     <pageType>region</pageType>
</rde-dm:iolet>

 *  
 *  components/flight-deals
 *  
 * city
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
	<pos>UK</pos>
	<module>components/flight-deals</module>
	<currency>&pound;</currency>
	<errTitle>err</errTitle>
	<errText>err</errText>
	<rname>worldwide,worldwide</rname>
	<rname>A,north</rname>
	<rname>B,Europe</rname>
	<rname>C,Asia</rname>     
	<rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 * country

<rde-dm:iolet name="nodeModules" method="GetModule" value="australia">
     <pos>UK</pos>
     <module>components/flight-deals</module>
     <currency>&pound;</currency>
     <pageType>country</pageType>
     <errTitle>error title</errTitle>
     <errText>error description</errText>
     <flightTypesLabels>return,return</flightTypesLabels>
     <flightTypesLabels>oneway,oneway</flightTypesLabels>
     <topOffer>MIL,return</topOffer><topOffer>BKK,oneway</topOffer><topOffer>SYD,return</topOffer> 
     <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *  
 *  components/other-destinations
 *  
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
     <pos>UK</pos>
     <module>components/other-destinations</module>
     <currency>&pound;</currency>
     <flight>NYC,return,/static/uk_division_web_ed/assets/hayley-mascot1.jpg,#,tag1,C</flight>
     <flight>LAX,oneway,/static/uk_division_web_ed/assets/hayley-mascot1.jpg,#,tag2,B</flight>
     <flight>BOS,oneway,/static/uk_division_web_ed/assets/hayley-mascot1.jpg,#,tag3,D</flight>
     <flight>LAS,return,/static/uk_division_web_ed/assets/hayley-mascot1.jpg,#,tag4,E</flight>
     <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *  
 *  components/trending-flights/trending
 *  
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <currency>&pound;</currency>
    <fromLabel>from</fromLabel>
    <module>components/trending-flights/trending</module>
    <route>LHR,SYD,return,#,false</route><route>LHR,BKK,return,#,false</route><route>LHR,REK,return,#,false</route>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *  components/trending-flights/domestic
 *  
 *  components/blog
 *  
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <module>components/blog</module>
    <url>http://www.statravel.com/blog/feed/</url>
    <rcid>B</rcid>
    <postsAmount>10</postsAmount>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

// labels/hero-banner-airline
// labels/hero-banner-region

 *
 *  labels/hero-banner-country
 *  
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <module>labels/hero-banner-country</module>
    <countryName>Australia</countryName>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *
 *  labels/destination-content-country
 *  
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
    <pos>UK</pos>
    <module>labels/destination-content-country</module>
    <type>return</type>
    <fromLabel>from</fromLabel>
    <currency>&pound;</currency>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *
 *  labels/destination-content-region
 *  
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <module>labels/destination-content-region</module>
    <countryName>Australia</countryName>
    <type>return</type>
    <fromLabel>from</fromLabel>
    <currency>&pound;</currency>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

 *  
 *  labels/blue-ticket-airline
 *  
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <module>labels/blue-ticket-airline</module>
    <airline>LH</airline>
</rde-dm:iolet>

 *
 *	labels/map-pin-price
 *
<rde-dm:iolet name="nodeModules" method="GetModule">
    <pos>UK</pos>
    <module>labels/map-pin-price</module>
    <rcid>B</rcid>
</rde-dm:iolet>

 *
 *	labels/top-offer-country
 *
 * /labels/top-offer-country?pos=UK&destination=SYD&type=oneway&from=from&currency=
 * 
<rde-dm:iolet name="nodeModules" method="GetModule" value="SYD">
    <pos>UK</pos>
    <module>labels/top-offer-country</module>
    <type>oneway</type>
    <fromLabel>from</fromLabel>
    <currency>&pound;</currency>
    <rde-dm:attribute mode="read" attribute="request:from" tag="iataFrom"/>
</rde-dm:iolet>

**/

public class NodeModules extends IoletAdapter {

	private static final String SOURCE_PARAM_NAME = "source";
	private static final String POS_PARAM_NAME = "pos";
	private static final String MODULE_PARAM_NAME = "module";
	private static final String PAGE_TYPE_PARAM_NAME = "pageType";
	
	private static final String FROM_PARAM_NAME = "iataFrom";
	private static final String AIRLINE_PARAM_NAME = "airline";
	private static final String RCID_PARAM_NAME = "rcid";
	private static final String COUNTRY_NAME_PARAM_NAME = "countryName";
	private static final String POSTS_AMOUNT_PARAM_NAME = "postsAmount";
	private static final String URL_PARAM_NAME = "url";
	private static final String TYPE_PARAM_NAME = "type";
	private static final String TOP_OFFER_TYPE_PARAM_NAME = "topOfferType";
	private static final String TOP_OFFER_PARAM_NAME = "topOffer";

	private static final String FLIGHT_PARAM_NAME = "flight";
	private static final String ROUTE_PARAM_NAME = "route";
	private static final String REGION_NAME_PARAM_NAME = "rname";
	
	private static final String TITLE_LABEL_PARAM_NAME = "titleLabel";
	private static final String TITLE_CLASS_PARAM_NAME = "titleClass";
	private static final String CURRENCY_PARAM_NAME = "currency";
	private static final String TYPE_LABEL_PARAM_NAME = "typeLabel";
	private static final String FROM_LABEL_PARAM_NAME = "fromLabel";
	private static final String TO_LABEL_PARAM_NAME = "toLabel";
	private static final String FLIGHT_TYPE_LABEL_PARAM_NAME = "flightTypesLabels";
	
	private static final String ERR_TITLE_PARAM_NAME = "errTitle";
	private static final String ERR_TEXT_PARAM_NAME = "errText";
	
	private static final String IS_OPEN_NEW_TAB_FLAG_PARAM_NAME = "isOpenLinkInNewTab";

	private static final String SOURCE_CLIENT = "client";
	private static final String ENCODE = "UTF-8";
	
	private static final String URL_PREFIX = DSConfig.getDSConfig().getProperty(DSConfig.NODE_HOST_PROP_NAME) + ":"
	+ DSConfig.getDSConfig().getProperty(DSConfig.NODE_PORT_PROP_NAME) + "/";

	private static int TIMEOUT = DSConfig.getTimeout();
	

	public final IoletResponse doGetModule(CoaSession session, IoletRequest request) {
		Long start = System.currentTimeMillis();
		String response = "";
		String source = request.getParameter(SOURCE_PARAM_NAME);
		
		if (!SOURCE_CLIENT.equalsIgnoreCase(source)) {
			String url = buildUrl(request);
			response = readModule(url);
		}
		
		Long finish = System.currentTimeMillis();
		response += comment("loaded: " + (finish - start) + " ms");
		
		return IoletResponseFactory.getIoletResponse(response);
	}

	public final IoletResponse doReadProperties(CoaSession session, IoletRequest request) throws Exception {
		String res = comment(DSConfig.getDSConfig().getProperty(DSConfig.NODE_HOST_PROP_NAME))
				+ comment(DSConfig.getDSConfig().getProperty(DSConfig.NODE_PORT_PROP_NAME))
				+ comment(Integer.toString(TIMEOUT));
		return IoletResponseFactory.getIoletResponse(res);
	}

	private final String readModule(final String url) {
		String content = comment(url);
	  	try {
			URL contentUrl = new URL(url);

			URLConnection conn = contentUrl.openConnection();
			conn.setConnectTimeout(TIMEOUT);
			conn.setReadTimeout(TIMEOUT);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				content += inputLine;
			in.close();
		} catch (Exception e) {
			content += comment(e.getMessage());
		}
	  	
	  	return content;
	}
	
	private final String buildUrl(final IoletRequest request) {
		
		String cityCode = request.getValue();

		String pos = request.getParameter(POS_PARAM_NAME);
		String moduleName = request.getParameter(MODULE_PARAM_NAME);
		String pageType = request.getParameter(PAGE_TYPE_PARAM_NAME);
		String fromCode = request.getParameter(FROM_PARAM_NAME);
		String regionCode = request.getParameter(RCID_PARAM_NAME);
		String countryName = request.getParameter(COUNTRY_NAME_PARAM_NAME);
		String airline = request.getParameter(AIRLINE_PARAM_NAME);
		String postsAmount = request.getParameter(POSTS_AMOUNT_PARAM_NAME);
		String type = request.getParameter(TYPE_PARAM_NAME);
		String topOfferType = request.getParameter(TOP_OFFER_TYPE_PARAM_NAME);
		String titleClass = request.getParameter(TITLE_CLASS_PARAM_NAME);
		String urlParam = encode( (String)request.getParameter(URL_PARAM_NAME) );
		String currency = encode( (String)request.getParameter(CURRENCY_PARAM_NAME) );
		String titleLabel = encode( (String)request.getParameter(TITLE_LABEL_PARAM_NAME) );
		String typeLabel = request.getParameter(TYPE_LABEL_PARAM_NAME);
		String fromLabel = encode( (String)request.getParameter(FROM_LABEL_PARAM_NAME) );
		String toLabel = encode( (String)request.getParameter(TO_LABEL_PARAM_NAME) );
		String errTitle = encode( (String)request.getParameter(ERR_TITLE_PARAM_NAME) );
		String errText = encode( (String)request.getParameter(ERR_TEXT_PARAM_NAME) );
		
		String isOpenLinkInNewTab = request.getParameter(IS_OPEN_NEW_TAB_FLAG_PARAM_NAME);
		
		Object flight = request.getParameter(FLIGHT_PARAM_NAME);
		Object route = request.getParameter(ROUTE_PARAM_NAME);
		Object regionName = request.getParameter(REGION_NAME_PARAM_NAME);
		Object flightTypesLabels = request.getParameter(FLIGHT_TYPE_LABEL_PARAM_NAME);
		Object topOffer = request.getParameter(TOP_OFFER_PARAM_NAME);
		
		StringBuilder url = new StringBuilder();
		url.append(URL_PREFIX).append(moduleName)
		.append("?pos=").append(pos)
		.append(createParam(pageType, "&pageType="))
		.append(createParam(cityCode, "&destination="))
		.append(createParam(fromCode, "&origin="))
		.append(createParam(regionCode, "&region="))
		.append(createParam(countryName, "&country="))
		.append(createParam(airline, "&airline="))
		.append(createParam(postsAmount, "&postsAmount="))
		.append(createParam(type, "&type="))
		.append(createParam(topOfferType, "&topOfferType="))
		.append(createParam(urlParam, "&url="))
		.append(createParam(typeLabel, "&typeLabel="))
		.append(createParam(titleLabel, "&titleLabel="))
		.append(createParam(titleClass, "&titleClass="))
		.append(createParam(currency, "&currency="))
		.append(createParam(fromLabel, "&from="))
		.append(createParam(toLabel, "&to="))
		.append(createParam(errTitle, "&errTitle="))
		.append(createParam(errText, "&errText="))
		.append(createParam(isOpenLinkInNewTab, "&isOpenLinkInNewTab="))
		.append(createParamSet(flight, FLIGHT_PARAM_NAME))
		.append(createParamSet(route, ROUTE_PARAM_NAME))
		.append(createParamSet(regionName, REGION_NAME_PARAM_NAME))
		.append(createParamSet(flightTypesLabels, FLIGHT_TYPE_LABEL_PARAM_NAME))
		.append(createParamSet(topOffer, TOP_OFFER_PARAM_NAME));
		
	  	return url.toString();
	}
	
	private static final String encode(String str) {
		if (str != null) {
			try {
				str = URLEncoder.encode(str, ENCODE);
			}
			catch (UnsupportedEncodingException e) {
				str = null;
			}
		}
		return str;
	}
	
	private static final String createParam(String p, String name) {
		return (p != null) ? name + p : "";
	}
	
	private static final String createParamSet(Object o, String name) {
		return (o != null) ? collect(o, name) : "";
	}

	private static final String collect(Object o, String name) {
		StringBuilder res = new StringBuilder();
		name = "&" + name + "=";
		if (o instanceof String[]) {
			String[] items = ((String[])o);
			for (int i=0; i<items.length; i++) {
				res.append(name)
				.append(encode( items[i] ));
			}
		}
		else {
			res.append(name)
			.append(encode( o.toString() ));
		}
		return res.toString();
	}
	
	private static final String comment(String comment) {
		return "<!-- " + comment + " -->";
	}
}
