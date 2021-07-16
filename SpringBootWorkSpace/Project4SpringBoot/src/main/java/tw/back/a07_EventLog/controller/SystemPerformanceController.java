package tw.back.a07_EventLog.controller;

import java.io.File;
import java.lang.management.ManagementFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.management.OperatingSystemMXBean;

@Controller
@RequestMapping("/back/systemPerformance")
public class SystemPerformanceController {

	Runtime lRuntime = Runtime.getRuntime();
	long freeM = lRuntime.freeMemory() / 1024 / 1024;
	long maxM = lRuntime.maxMemory() / 1024 / 1024;
	long tM = lRuntime.totalMemory() / 1024 / 1024;
	OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	java.lang.management.ThreadMXBean t = ManagementFactory.getThreadMXBean();
	File[] roots = File.listRoots(); // 取得硬碟分區

	@GetMapping("/Main")
	public void systemPerformanceMain() {
		while (true) {
			getMyData();
			System.out.println("----------------------------------------------");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getMyData() {
		long totalMem = osmb.getTotalPhysicalMemorySize();
		long freeMem = osmb.getFreePhysicalMemorySize();
		double useMem = (double) (totalMem-freeMem)/totalMem;
		
		System.out.println("系統物理記憶體總計：" + (osmb.getTotalPhysicalMemorySize() / 1024 / 1024) + " MB");
		System.out.println("系統物理記憶體可用：" + (osmb.getFreePhysicalMemorySize() / 1024 / 1024) + " MB");

		System.out.println("系統物理記憶體使用率：" + useMem*100 +" %" );

		
		System.out.println("CPU 使用率(系統)：" + (osmb.getSystemCpuLoad() * 100) + " %");
		System.out.println("系统磁盘使用情况：");
		for (File file : roots) {
			System.out.print(file.getPath());
			System.out.print(" 未使用：" + (file.getFreeSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.print(" 可用：" + (file.getUsableSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.print(" 總空間：" + (file.getTotalSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.println();
		}
	}

	public void getAllData() {

		System.out.println("本程式執行緒數量：" + t.getThreadCount());
		System.out.println("JVM 執行緒數量：" + t.getDaemonThreadCount());
		System.out.println("最大執行緒數量：" + t.getPeakThreadCount());
		System.out.println();
		System.out.println("本程式最大記憶體：" + maxM + " MB");
		System.out.println("本程式可用記憶體：" + freeM + " MB");
		System.out.println("本程式總記憶體：" + tM + " MB");
		System.out.println();
		System.out.println("系統物理記憶體總計：" + (osmb.getTotalPhysicalMemorySize() / 1024 / 1024) + " MB");
		System.out.println("系統物理記憶體可用：" + (osmb.getFreePhysicalMemorySize() / 1024 / 1024) + " MB");
		System.out.println("系統交換記憶體總計：" + (osmb.getTotalSwapSpaceSize() / 1024 / 1024) + " MB");
		System.out.println("系統交換記憶體可用：" + (osmb.getFreeSwapSpaceSize() / 1024 / 1024) + " MB");
		System.out.println();
		System.out.println("CPU 使用率(本程式)：" + (osmb.getProcessCpuLoad() * 100) + " %");
		System.out.println("CPU 使用率(系統)：" + (osmb.getSystemCpuLoad() * 100) + " %");
		System.out.println("CPU 時間：" + osmb.getProcessCpuTime());
		System.out.println();
		System.out.println("系统磁盘使用情况：");
		for (File file : roots) {
			System.out.print(file.getPath());
			System.out.print(" 未使用：" + (file.getFreeSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.print(" 可用：" + (file.getUsableSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.print(" 總空間：" + (file.getTotalSpace() / 1024 / 1024 / 1024) + " GB \t");
			System.out.println();
		}
	}
}
