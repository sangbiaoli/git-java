package com.sangbill.io.randomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PartsDB {
	public final static int PARTNUM_LEN = 20;
	public final static int DESC_LEN = 30;
	public final static int QUAN_LEN = 4;
	public final static int COST_LEN = 4;
	private final static int REC_LEN = 2 * PARTNUM_LEN + 2 * DESC_LEN + QUAN_LEN + COST_LEN;
	private RandomAccessFile raf;

	public PartsDB(String path) throws IOException {
		raf = new RandomAccessFile(path, "rw");
	}

	public void append(String partnum, String partdesc, int qty, int ucost) throws IOException {
		raf.seek(raf.length());
		write(partnum, partdesc, qty, ucost);
	}

	public void close() {
		try {
			raf.close();
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}

	public int numRecs() throws IOException {
		return (int) raf.length() / REC_LEN;
	}

	public Part select(int recno) throws IOException {
		if (recno < 0 || recno >= numRecs())
			throw new IllegalArgumentException(recno + " out of range");
		raf.seek(recno * REC_LEN);
		return read();
	}

	public void update(int recno, String partnum, String partdesc, int qty, int ucost) throws IOException {
		if (recno < 0 || recno >= numRecs())
			throw new IllegalArgumentException(recno + " out of range");
		raf.seek(recno * REC_LEN);
		write(partnum, partdesc, qty, ucost);
	}

	private Part read() throws IOException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < PARTNUM_LEN; i++)
			sb.append(raf.readChar());
		String partnum = sb.toString().trim();
		sb.setLength(0);
		for (int i = 0; i < DESC_LEN; i++)
			sb.append(raf.readChar());
		String partdesc = sb.toString().trim();
		int qty = raf.readInt();
		int ucost = raf.readInt();
		return new Part(partnum, partdesc, qty, ucost);
	}

	private void write(String partnum, String partdesc, int qty, int ucost) throws IOException {
		StringBuffer sb = new StringBuffer(partnum);
		if (sb.length() > PARTNUM_LEN)
			sb.setLength(PARTNUM_LEN);
		else if (sb.length() < PARTNUM_LEN) {
			int len = PARTNUM_LEN - sb.length();
			for (int i = 0; i < len; i++)
				sb.append(" ");
		}
		raf.writeChars(sb.toString());
		sb = new StringBuffer(partdesc);
		if (sb.length() > DESC_LEN)
			sb.setLength(DESC_LEN);
		else if (sb.length() < DESC_LEN) {
			int len = DESC_LEN - sb.length();
			for (int i = 0; i < len; i++)
				sb.append(" ");
		}
		raf.writeChars(sb.toString());
		raf.writeInt(qty);
		raf.writeInt(ucost);
	}

	public static class Part {
		private String partnum;
		private String desc;
		private int qty;
		private int ucost;

		public Part(String partnum, String desc, int qty, int ucost) {
			this.partnum = partnum;
			this.desc = desc;
			this.qty = qty;
			this.ucost = ucost;
		}

		String getDesc() {
			return desc;
		}

		String getPartnum() {
			return partnum;
		}

		int getQty() {
			return qty;
		}

		int getUnitCost() {
			return ucost;
		}
	}
}