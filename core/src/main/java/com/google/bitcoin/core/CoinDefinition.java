package com.google.bitcoin.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {
    private static final Logger log = LoggerFactory.getLogger(CoinDefinition.class);

    public static final String coinName = "BitRevShares";
    public static final String coinTicker = "REV";
    public static final String coinURIScheme = "bitrevshares";
    public static final String coinURIScheme2 = "rev";
    public static final String coinInternalName = "bitrevshares";
    public static final String cryptsyMarketId = "71";
    public static final String cryptsyMarketCurrency = "REV";
    public static final String PATTERN_PRIVATE_KEY_START = "[U7]";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://revexplorer.com/";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.revexplorer.com/";
    //public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://rev.blockr.io/";
    //public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://rev.blockr.io/";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";
    public static final String BLOCKEXPLORER_PATH_URL_TEST = "block/";

    public static final String DONATION_ADDRESS = "RNacLWF2P9hrq1RhdAjk1UDLqfrRfUzJxt";

    enum CoinHash {
        SHA256,
        scrypt,
        quark
    };
    public static final CoinHash coinHash = CoinHash.quark;

    public static boolean checkpointFileSupport = false;
    public static int checkpointDaysBack = 21;
    //Original Values
    public static final int TARGET_TIMESPAN = (int)(10 * 60);  // 10 minutes per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL*100;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }
    public static int getMaxTimeSpan(int value, int height, boolean testNet)
    {
            return value * 110 / 100;
    }
    public static int getMinTimeSpan(int value, int height, boolean testNet)
    {
            return value / 2;
    }
    public static int spendableCoinbaseDepth = 120; //main.h: static const int COINBASE_MATURITY
    public static BigInteger COIN = BigInteger.valueOf(100000000);
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(10000000).multiply(COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static BigInteger CENT = BigInteger.valueOf(1000000);
    public static BigInteger mCOIN = BigInteger.valueOf(100000);

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DEFAULT_MIN_RELAY_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(100000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 55669;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 65669;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 60;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 9;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS

    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xfea503dd;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1487177588L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (908741273);                      //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000090d4dcdef966b728f50fb8fae857bf77057559d8ab559e848ecde6a71b"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 1;                                                               //main.cpp: LoadBlockIndex

    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c5c313520466562727561727920323031372c20436f696e4465736b2c204d6963726f736f6674205465616d732057697468204b504d4720746f204c61756e636820426c6f636b636861696e20576f726b7370616365204e6574776f726b";
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
        "seed1.bitrevshares.com",
        "seed2.bitrevshares.com",
        "s1.bitrevshares.com",
        "s2.bitrevshares.com"
    };
    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - quarkcoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 119;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 199;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x011a39f7;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "000002251f05cc61714724d1d971d808ba0f4c07dc11e8d5987946dcf70e82de";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1487177600L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (911043093);                         //main.cpp: LoadBlockIndex

    static final long _COIN = 100000000;
    static final BigInteger nGenesisBlockRewardCoin = COIN;
    static final BigInteger nBlockRewardIcoCoin = BigInteger.valueOf(1000000 * _COIN);
    static final BigInteger nBlockRewardCoin = BigInteger.valueOf(350000000);
    static final BigInteger nEndBlockRewardCoin = COIN;

    //main.cpp GetBlockValue(height, fee)
    static final BigInteger GetBlockValue(int nHeight)
    {
        if (nHeight == 0)
        {
            return nGenesisBlockRewardCoin;
        }
        else if(nHeight == 1)
        {
            return nBlockRewardIcoCoin;
        }
        else if(nHeight < 2571430)
        {
            return nBlockRewardCoin;
        }
        else if(nHeight > 2571430)
        {
            return BigInteger.valueOf(0);
        }
        else
        {
            return nEndBlockRewardCoin;
        }
    }

    public static int subsidyDecreaseBlockCount = 60480;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
        "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0493e6dc310a0e444cfb20f3234a238f77699806d47909a42481010c5ce68ff04d3babc959cd037bd3aa6ded929f2b9b4aa2f626786cd7f8495e5bb61e9cfebbc4";
    public static final String TESTNET_SATOSHI_KEY = "04218bc3f08237baa077cb1b0e5a81695fcf3f5b4e220b4ad274d05a31d762dd4e191efa7b736a24a32d6fd9ac1b5ebb2787c70e9dfad0016a8b32f7bd2520dbd5";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "com.bitrevshares.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "com.bitrevshares.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.bitrevshares.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
      checkpoints.put(     0,  new Sha256Hash("00000090d4dcdef966b728f50fb8fae857bf77057559d8ab559e848ecde6a71b"));
      checkpoints.put(   100,  new Sha256Hash("000003fca21bb1960dd95e604efd98fc6f17c514ee7b39f302081aadb7896069"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "R9LAaDypbFUTKpiFg73WYHzLn6i17ih38q";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "UXe9UTQdEh5YoYpSAHeqwq7Cfi6LNBAyUyJnjShFAdPpEWu3EdcF";
}
