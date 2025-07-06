
# 🚀 Java Input/Output Methods for Competitive Programming

Efficient input and output (I/O) is **critical** in competitive programming. Java is slower than C++ by default, so choosing the right I/O method can mean the difference between **AC (Accepted)** and **TLE (Time Limit Exceeded)**.

This guide compares popular Java input methods with examples and time complexity.

---

## 📊 Comparison Table

| Feature               | `Scanner`     | `BufferedReader`            | `BufferedReader + StringTokenizer` |
| --------------------- | ------------- | --------------------------- | ---------------------------------- |
| Input speed           | ❌ Slow        | ✅ Fast                      | 🔥 Fastest                         |
| Output (`System.out`) | ❌ Slow        | ✅ Fast (with `PrintWriter`) | 🔥 Very fast (`BufferedWriter`)    |
| Suitable for contests | ❌ Risk of TLE | ✅ Good                      | ✅✅ Best                            |

---

## 🧠 Time Complexity Analysis

| Method                          | Time Complexity     | Notes                          |
|---------------------------------|---------------------|--------------------------------|
| `Scanner.nextInt()`             | O(n) per token      | Uses regex + tokenization     |
| `BufferedReader.readLine()`     | O(L) per line       | L = line length               |
| `.split(" ")`                   | O(k) per line       | k = number of splits          |
| `StringTokenizer`               | O(1) per token avg. | Much faster than `.split()`  |
| `Integer.parseInt(String s)`    | O(d)                | d = number of digits (≤10)    |

---

## 🔎 Code Examples

### 1. ❌ Using `Scanner` (TLE Risk)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
```

> Simple but slow. Avoid this for `t > 10^4`.

---

### 2. ✅ Using BufferedReader + split()

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            System.out.println(a + b);
        }
    }
}
```

> Faster than Scanner. Suitable for most problems.

---

### 3. 🔥 Using BufferedReader + StringTokenizer + BufferedWriter

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write((a + b) + "\n");
        }

        bw.flush(); // Important!
    }
}
```

> Fastest combo for input + output.  
> Used in ICPC, Codeforces, CSES, AtCoder, etc.

---

## 💡 Why Is Scanner Slower?

- Uses regex for token parsing  
- More function calls and checks  
- Each `nextInt()` involves multiple layers of processing  

---

## ✅ Recommendation

| Input Size         | Best I/O Method                             |
|--------------------|---------------------------------------------|
| Small (< 10⁴)      | `Scanner` or `BufferedReader`               |
| Medium (< 10⁵)     | `BufferedReader + split()`                  |
| Large (>= 10⁵)     | `BufferedReader + StringTokenizer + BufferedWriter` |

---

## 🧪 Benchmark (for reading 10⁵ pairs of integers)

| Method                               | Time (ms approx) |
|--------------------------------------|------------------|
| `Scanner`                            | 500–800 ms       |
| `BufferedReader + split()`           | 150–250 ms       |
| `BufferedReader + StringTokenizer`   | 80–150 ms        |

---

## 📦 TL;DR

- Use `Scanner` only for small inputs.  
- Prefer `BufferedReader` for competitive programming.  
- For fastest I/O: `BufferedReader + StringTokenizer + BufferedWriter`.

---

### ✅ Want More?

Let me know if you'd like:

- 🔁 Multiline input handling examples  
- 🔢 Matrix or grid reading templates  
- ⚡ A reusable `FastReader` class template  

