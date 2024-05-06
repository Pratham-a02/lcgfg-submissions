<h2><a href="https://leetcode.com/problems/filter-elements-from-array/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2634. Filter Elements from Array</a></h2><h3>Easy</h3><hr><div><p>Given an integer array <code>arr</code> and a filtering function <code>fn</code>, return a filtered array <code>filteredArr</code>.</p>

<p>The <code>fn</code> function takes one or two arguments:</p>

<ul>
	<li><code>arr[i]</code> - number&nbsp;from&nbsp;the <code>arr</code></li>
	<li><code>i</code>&nbsp;- index of <code>arr[i]</code></li>
</ul>

<p><code>filteredArr</code> should only contain the elements from the&nbsp;<code>arr</code> for which the expression <code>fn(arr[i], i)</code> evaluates to a <strong>truthy</strong> value. A&nbsp;<strong>truthy</strong>&nbsp;value is a value where&nbsp;<code>Boolean(value)</code>&nbsp;returns&nbsp;<code>true</code>.</p>

<p>Please solve it without the built-in <code>Array.filter</code> method.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [0,10,20,30], fn = function greaterThan10(n) { return n &gt; 10; }
<strong>Output:</strong> [20,30]
<strong>Explanation:</strong>
const newArray = filter(arr, fn); // [20, 30]
The function filters out values that are not greater than 10</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1,2,3], fn = function firstIndex(n, i) { return i === 0; }
<strong>Output:</strong> [1]
<strong>Explanation:</strong>
fn can also accept the index of each element
In this case, the function removes elements not at index 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [-2,-1,0,1,2], fn = function plusOne(n) { return n + 1 }
<strong>Output:</strong> [-2,0,1,2]
<strong>Explanation:</strong>
Falsey values such as 0 should be filtered out
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>