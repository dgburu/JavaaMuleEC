package com.iukonline.amule.ec;

import java.net.InetSocketAddress;
import java.util.zip.DataFormatException;

public class ECServer {
    
    
    private byte detailLevel;
    
    private long serverPing;
    private byte serverPrio;
    private String serverVersion;
    private String serverDesc;
    private long serverUsers;
    private long serverUsersMax;
    private long serverFiles;
    private String serverName;
    
    InetSocketAddress serverAddr;
    
    
    public ECServer(ECTag t1, byte d) throws ECException {
        
        detailLevel = d;
        ECTag t;

        try {
            
            switch (detailLevel) {
            case ECCodes.EC_DETAIL_FULL:
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_PING);
                if (t != null) serverPing = t.getTagValueUInt();
                else throw new ECException("Missing EC_TAG_SERVER_PING in server response");
                
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_PRIO);
                if (t != null) serverPrio = (byte) t.getTagValueUInt();
                else throw new ECException("Missing EC_TAG_SERVER_PRIO in server response");
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_VERSION);
                if (t != null) serverVersion = t.getTagValueString();
                else throw new ECException("Missing EC_TAG_SERVER_VERSION in server response");
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_DESC);
                if (t != null) serverDesc = t.getTagValueString();
                else throw new ECException("Missing EC_TAG_SERVER_DESC in server response");
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_USERS);
                if (t != null) serverUsers = t.getTagValueUInt();
                else throw new ECException("Missing EC_TAG_SERVER_USERS in server response");

                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_USERS_MAX);
                if (t != null) serverUsersMax = t.getTagValueUInt();
                else throw new ECException("Missing EC_TAG_SERVER_USERS_MAX in server response");
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_FILES);
                if (t != null) serverFiles = t.getTagValueUInt();
                else throw new ECException("Missing EC_TAG_SERVER_FILES in server response");
                
            case ECCodes.EC_DETAIL_WEB:
            case ECCodes.EC_DETAIL_CMD:
                
                t = t1.getSubTagByName(ECCodes.EC_TAG_SERVER_NAME);
                if (t != null) serverName = t.getTagValueString();
                else throw new ECException("Missing EC_TAG_SERVER_NAME in server response");

                
                serverAddr = t1.getTagValueIPv4();
                
                break;
                
            default:
                throw new ECException("Unknown detail level " + detailLevel + " for EC_TAG_SERVER");

            }
            
        } catch (DataFormatException e) {
            throw new ECException("One or more unexpected type in EC_TAG_SERVER tags", e);
        }
        
    }


    public byte getDetailLevel() {
        return detailLevel;
    }


    public long getServerPing() {
        return serverPing;
    }


    public byte getServerPrio() {
        return serverPrio;
    }


    public String getServerVersion() {
        return serverVersion;
    }


    public String getServerDesc() {
        return serverDesc;
    }


    public long getServerUsers() {
        return serverUsers;
    }


    public long getServerUsersMax() {
        return serverUsersMax;
    }


    public long getServerFiles() {
        return serverFiles;
    }


    public String getServerName() {
        return serverName;
    }


    public InetSocketAddress getServerAddr() {
        return serverAddr;
    }


    @Override
    public String toString() {
        return String.format(
                        "ECServer [detailLevel=%s, serverPing=%s, serverPrio=%s, serverVersion=%s, serverDesc=%s, serverUsers=%s, serverUsersMax=%s, serverFiles=%s, serverName=%s, serverAddr=%s]",
                        detailLevel, serverPing, serverPrio, serverVersion, serverDesc, serverUsers, serverUsersMax, serverFiles, serverName, serverAddr);
    }

    

}
