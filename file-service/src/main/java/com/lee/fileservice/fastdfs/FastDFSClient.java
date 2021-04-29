package com.lee.fileservice.fastdfs;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
@Slf4j
public class FastDFSClient {
	static {
		try {
//			String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();;
			String filePath = new ClassPathResource("fdfs_client.conf").getPath();
			ClientGlobal.init(filePath);
		} catch (Exception e) {
			log.error("FastDFS Client Init Fail!",e);
		}
	}

	public static String[] upload(FastDFSFile file) {
		log.info("File Name: " + file.getName() + "File Length:" + file.getContent().length);

		NameValuePair[] metaList = new NameValuePair[1];
		metaList[0] = new NameValuePair("author", file.getAuthor());

		long startTime = System.currentTimeMillis();
		String[] uploadResults = null;
		StorageClient storageClient=null;
		try {
			storageClient = getStorageClient();
			uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), metaList);
		} catch (IOException e) {
			log.error("IO Exception when uploading the file:" + file.getName(), e);
		} catch (Exception e) {
			log.error("Non IO Exception when uploading the file:" + file.getName(), e);
		}
		log.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");

		if (uploadResults == null && storageClient!=null) {
			log.error("upload file fail, error code:" + storageClient.getErrorCode());
		}
		String groupName = uploadResults[0];
		String remoteFileName = uploadResults[1];

		log.info("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
		return uploadResults;
	}

	public static FileInfo getFile(String groupName, String remoteFileName) {
		try {
			StorageClient storageClient = getStorageClient();
			return storageClient.get_file_info(groupName, remoteFileName);
		} catch (IOException e) {
			log.error("IO Exception: Get File from Fast DFS failed", e);
		} catch (Exception e) {
			log.error("Non IO Exception: Get File from Fast DFS failed", e);
		}
		return null;
	}

	public static InputStream downFile(String groupName, String remoteFileName) {
		try {
			StorageClient storageClient = getStorageClient();
			byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
			InputStream ins = new ByteArrayInputStream(fileByte);
			return ins;
		} catch (IOException e) {
			log.error("IO Exception: Get File from Fast DFS failed", e);
		} catch (Exception e) {
			log.error("Non IO Exception: Get File from Fast DFS failed", e);
		}
		return null;
	}

	public static void deleteFile(String groupName, String remoteFileName)
			throws Exception {
		StorageClient storageClient = getStorageClient();
		int i = storageClient.delete_file(groupName, remoteFileName);
		log.info("delete file successfully!!!" + i);
	}

	public static void deleteFile(String fileId) throws IOException, MyException {
		StorageClient1 storageClient1 = getStorageClient1();
		int i = storageClient1.delete_file1(fileId);
		log.info("delete file successfully!!!" + i);
	}

	public static StorageServer[] getStoreStorages(String groupName)
			throws IOException {
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		return trackerClient.getStoreStorages(trackerServer, groupName);
	}

	public static ServerInfo[] getFetchStorages(String groupName,
												String remoteFileName) throws IOException {
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
	}

	public static String getTrackerUrl() throws IOException {
		return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
	}

	private static StorageClient getStorageClient() throws IOException {
		TrackerServer trackerServer = getTrackerServer();
		return new StorageClient(trackerServer, null);
	}

	private static StorageClient1 getStorageClient1() throws IOException {
		TrackerServer trackerServer = getTrackerServer();
		return new StorageClient1(trackerServer, null);
	}

	private static TrackerServer getTrackerServer() throws IOException {
		TrackerClient trackerClient = new TrackerClient();
		return trackerClient.getConnection();
	}
}