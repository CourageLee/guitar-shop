package com.lee.paymentservice.controller;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/4 14:13
 */
public class Config {
    public static final String APP_ID = "2021000117648472";
    public static final String CHARSET = "UTF-8";
    public static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC/J0nJiqN/MFEVjMD7M+VmGSefibBbOkQ6RqOoLsQqThZDIWHDtqr77RRi3i6gBBM5EWQh6Y5a9mtpYyoQ/r7C6nyhd11jFWDUduPDqGSda98qiASfbMPYNIzHYyxvKRwPkKlvwbOxhfEyWapm18kztnDWLYPOCyHWVBVRLyxy96UIbqey+EYd85SvMpcxlqzI4rnCzatZifHxK2G6ujAgmFlM/PdbUqbxJsbdeCIql21uVy1XSqdEhesDI/Dg4XLkLl8ThKajK8X+59rZDeiS+fpNs9NqpHqLL60c2woW08E39nBX6OoF/Sz9FX+ptse8iYgjzySH0vjPnRxDGdmFAgMBAAECggEADuPPkpxzCehImKYjLi4ns2FIPdwq2aBbSjLQcrxZ2XXFtCr4g5dKEF+yU9U8yogmuy5In3+i8CD70vS/hR1i3KoJVUaIBrzWkxZDvazzUXPiqVx5B7YgN0o4oRtvjaUlI21AVY1AIxbs5+AmLuamLJoMhhJ7juQ9GYXpNy62hqnzMtmJissOm/6Z7bxAMgYG/8VdEqX8G0lMFsHZ8Fr16yQIn+QnmlRWnXF9cPFTQgPmGlRHEjruMMOiYAwzt/AR9dcI5+QzUXcK6rAK91DfaFQcUeMrBYH6wQfZPBKBy7PYpIoJhRiaRGm9BpleMFL43elywOiXB13bUZzrldANQQKBgQDqTa170+UukNBPkfjJr/jkSl6m0HRW2wMhnnwLkhR+VTph7b9kgC5BTj1I9A6D+F2ax6G5VX9fG1ddG+8et5U6J2gDiNmGGBZgKwTGLTR8XGZBEl/sFcmUaptHOmmJFEBtknOc3iGyK2RE5k3SzHrp/jU/OYS7YcTtQbkveRzbkQKBgQDQ2rYekN2Qp03MZMbE6t0RRHpNnjMUixfetmFF5pvaG4EUtjTSxOFAyhJRNYwb5b50nUMZHYZ1jyOqWjbjgVDwx/U1IgGrkTvKiUU8UcslC2y6FZfByaWuEABALZOPcR4EC0ZyO/DfPlbXUq+QsnNRsF9iUmDhM9nbo/Fnj+LctQKBgGNmPtIIi/LcVrNbDvupXuKitlL4nlJ2qXZqwN87wtvxlkoTTZ36TyU/Zvp7J2lPRY6zYGW64sVbWQ3UGvaiFXnNW/Ab74RW1a9IsMbOSLT1kh/LBsymVZVUQLnQCxOvdsHFXqzPA+aNSAV+2scyHncEdFx1L107Vgr9Ve3Q6LAxAoGBALYmGXGc/G+9Sh+5wJVbFISLyXLKR1hiWuYU/88b6c8V78TliDpOFPoRglorLk/iVfGUekF8O5lpxjw7Q+W1Ead9bQDy8Kv2FUR15dlOqLJdPW0pidosCIA/WkietzQB/qCeSMk2N8QrtUdDyPSUffi/ruCsYevm8dkaKV8d4UiFAoGALDpHGsAurRnbOn/Yde1psw7GKXR0Z0R65OVSrwZPBRoSBkp80xg+/PKN5ekIHhBMu+SzOtF2/nZdpRE41Mx4ydZ0Yl43pNb4n//WZ8MCtyo4h81UCBirhv7sdWSpLzaGkrtQN7nzAhrm+/CLeD8np/jsjNegz5f8W+dlp4Mzt/0=";
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwAOvAsm5+cDUXujOXHTkUfAbLIBZdGmT541cCP/gGeeeVC1bE43W2RfDpJrLzkZ+OeVsfzIB7HHZ3w4F+RQxNeCa/vqMNB09j8WwcEe0nQyFR+uwcEtDMf8RczL9zhJyN2/a1wvl7KvhN+JxcotRnDWCu0jFEWeDKy7iMdXgIHSweZuJw0sf2Z7lkZdzHjrF25Szs7UFX+IiQsHbMBkG87uYoLRXlZbzdRnLCLo7EN0FKXDekV29/qNmzFUK0nGTGONVBZD9EcM95qorcVtXM8XsrdRL1919P56VSkjiJEoL6aJtsifePQhuOQdXaEHUk+1iPbwGo6ZfY+UbgVwwOwIDAQAB";
    public static final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    public static final String FORMAT = "JSON";
    public static final String SIGN_TYPE = "RSA2";
    public static final String NOTIFY_URL = "api.licongchun.com/payment/notify";
    public static final String RETURN_URL = "http://www.baidu.com";
}
